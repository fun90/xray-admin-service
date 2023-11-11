package com.fun90.admin.service.v2ray;


import com.fun90.admin.entity.V2rayAccount;
import com.fun90.admin.model.Account;
import com.fun90.admin.model.ProxyAccount;
import com.fun90.admin.model.Server;
import com.fun90.admin.model.User;
import com.fun90.admin.repository.UserRepository;
import com.fun90.admin.service.ServerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.Assert;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class XrayProxyEvent implements ProxyEvent {
//	private Server server;
	//	private String email;
	private String event;
	private Account account;
	private XrayService xrayService;
	private ServerService serverService;
	private UserRepository userRepository;
//	private V2rayAccountService v2rayAccountService;

	public static void main(String[] args) {
		V2rayAccount v2rayAccount = new V2rayAccount();

		System.out.println(v2rayAccount.getAid());

		System.out.println(DigestUtils.md5Hex("V9bdCGFdTjbA77j4ter"));
	}

	@Override
	public String getEvent() {
		return event;
	}

	public void updateEvent() {
		createEvent();
	}

	public void rmEvent() {
		ProxyAccount proxyAccount = buildProxyAccount();
		try {
			if (proxyAccount == null) return;
			xrayService.rmProxyAccount(proxyAccount);
		} catch (Exception e) {
			log.error("rmAccount error :{}", e.getLocalizedMessage(), e);
		}
	}

	public void createEvent() {
		ProxyAccount proxyAccount = buildProxyAccount();
		try {
			if (proxyAccount == null) return;
			xrayService.addProxyAccount(proxyAccount);
		} catch (Exception e) {
			log.error("addAccount error :{}", e.getLocalizedMessage(), e);
		}
	}

	public ProxyAccount buildProxyAccount() {
		User user = account.getUser();
		if (user == null) {
			Integer userId = account.getUserId();
			user = userRepository.findById(userId).orElse(null);
			Assert.notNull(user, "user is null");
		}
		List<Server> servers = serverService.queryXrayServers(account);
		Assert.notNull(servers, "servers is null");
		return ProxyAccount.build(account, user, servers);
	}

}
