package com.jhl.admin.service;

import com.jhl.admin.constant.ClientConstant;
import com.jhl.admin.model.Account;
import com.jhl.admin.model.Server;
import com.jhl.admin.model.Subscription;
import com.jhl.admin.repository.AccountRepository;
import com.jhl.admin.repository.SubscriptionRepository;
import com.jhl.admin.service.v2ray.XrayAccountService;
import com.jhl.admin.util.Utils;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubscriptionService {

	@Autowired
	AccountService accountService;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	SubscriptionRepository subscriptionRepository;
	@Autowired
	ServerService serverService;
	@Autowired
	XrayAccountService xrayAccountService;
	@Autowired
	ClientConstant clientConstant;

	/**
	 * 同一个code 订阅
	 *
	 * @param code
	 * @return base64后的数据
	 */
	public String subscribe(String code, String target) {
		Account account = findAccountByCode(code);
		Short level = account.getLevel();

		List<Server> servers = serverService.listByLevel(level);
		// 过滤服务器节点只保留协议被客户端支持的节点
		servers = servers.stream().filter(o -> clientConstant.getSupportProtocols().get(target).contains(o.getProtocol())).collect(Collectors.toList());
		
		if ("quanx".equals(target)) {
			StringBuilder sb = new StringBuilder();
			servers.forEach(s -> {
				sb.append(s.getProtocol()).append("=").append(s.getClientDomain()).append(":").append(s.getClientPort()).append(", ")
						.append("password=").append(account.getUuid())
						.append(", fast-open=false")
						.append(", udp-relay=true")
						.append(", tls13=false");
				if ("trojan".equals(s.getProtocol())) {
					sb.append(", tls-host=").append(s.getClientDomain())
							.append(", over-tls=true")
							.append(", tls-verification=false");
				} else if ("vmess".equals(s.getProtocol())) {
					sb.append(", method=chacha20-ietf-poly1305")
							.append(", obfs-host=").append(s.getClientDomain())
							.append(", obfs-uri=").append(s.getWsPath())
							.append(", obfs=wss");
				}
				sb.append(", tag=").append(s.getServerName()).append(System.lineSeparator());
			});
			return sb.toString();
		}
		
		String b64V2rayAccount = xrayAccountService.buildXrayServerUrl(servers, account);
		//需要再进行一次base64
		return Base64.encodeBase64String(b64V2rayAccount.getBytes(StandardCharsets.UTF_8));
	}


	public List<Server> findServers(Account account, String target) {
		Short level = account.getLevel();
		List<Server> servers = serverService.listByLevel(level);
		List<String> protocols = clientConstant.getSupportProtocols().get(target);
		return servers.stream().filter(o -> protocols.contains(o.getProtocol())).collect(Collectors.toList());
	}


	/**
	 * 通过一个订阅code寻找账号
	 *
	 * @param code
	 * @return
	 */
	public Account findAccountByCode(String code) {
		if (code == null) throw new IllegalArgumentException("code can't be null");
		Optional<Subscription> subscriptionOptional =
				subscriptionRepository.findOne(Example.of(Subscription.builder().code(code).build()));
		if (!subscriptionOptional.isPresent()) throw new IllegalArgumentException("the code doesn't exist");

		Integer accountId = subscriptionOptional.get().getAccountId();


		return accountRepository.findById(accountId).orElse(null);
	}

	public Subscription findByAccountId(Integer accountId) {
		if (accountId == null) throw new IllegalArgumentException(" can't be null");
		Optional<Subscription> subscriptionOptional =
				subscriptionRepository.findOne(Example.of(Subscription.builder().accountId(accountId).build()));

		return subscriptionOptional.orElse(null);
	}

	public void addSubscription(Subscription subscription) {
		if (subscription == null || subscription.getAccountId() == null) throw new RuntimeException(" can't be null");

		if (subscription.getCode() == null) subscription.setCode(generatorCode());

		subscriptionRepository.save(subscription);

	}

	/**
	 * @param code 可以为空
	 * @param id
	 */
	public void updateSubscription(String code, Integer id) {
		if (code == null) code = generatorCode();
		Subscription subscription = Subscription.builder().code(code).build();
		subscription.setId(id);
		subscriptionRepository.save(subscription);

	}


	public String generatorCode() {

		return Utils.getCharAndNum(10);
	}
}
