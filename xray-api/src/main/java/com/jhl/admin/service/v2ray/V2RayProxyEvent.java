package com.jhl.admin.service.v2ray;


import com.google.common.collect.Lists;
import com.jhl.admin.entity.V2rayAccount;
import com.jhl.admin.model.Account;
import com.jhl.admin.model.Server;
import com.jhl.admin.model.ProxyAccount;
import com.jhl.admin.model.User;
import com.jhl.admin.repository.UserRepository;
import com.jhl.admin.service.ServerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
public class V2RayProxyEvent implements ProxyEvent {
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
			List<Server> serverList = proxyAccount.getServers();
			addVLESSServer(serverList);
			xrayService.rmProxyAccount(proxyAccount);
		} catch (Exception e) {
			log.error("rmAccount error :{}", e.getLocalizedMessage());
		}
	}

	public void createEvent() {
		ProxyAccount proxyAccount = buildProxyAccount();
		try {
			if (proxyAccount == null) return;
			List<Server> serverList = proxyAccount.getServers();
			addVLESSServer(serverList);
			xrayService.addProxyAccount(proxyAccount);
		} catch (Exception e) {
			log.error("addAccount error :{}", e.getLocalizedMessage());
		}
	}

	// 临时方案
	private void addVLESSServer(List<Server> serverList) throws CloneNotSupportedException {
		for (Server server : serverList) {
			Server vlessServer = (Server) server.clone();
			vlessServer.setProtocol("VLESS");
			vlessServer.setInboundTag("vless_tcp_xtls");
			serverList.add(vlessServer);
		}
	}

	public ProxyAccount buildProxyAccount() {
//		String uuid = account.getUuid();
//		if (uuid == null) {
//			uuid = v2rayAccountService.buildV2rayAccount(Lists.newArrayList(server), account).get(0).getId();
//			account.setUuid(uuid);
//		}
		List<Server> servers = serverService.distinctServers(account);
		User user = account.getUser();
		if (user == null) {
			Integer userId = account.getUserId();
			user = userRepository.findById(userId).orElse(null);
			Assert.notNull(user, "user is null");
		}
		return ProxyAccount.build(account, user, servers);
	}

//	public List<String> buildProxyServerUrl() {
//		String[] proxyIps = server.getProxyIp().split(",");
//		List<String> urls = Lists.newArrayList();
//		for (String proxyIp : proxyIps) {
//			StringBuilder sb = new StringBuilder("http://");
//			sb.append(proxyIp).append(":").append(server.getProxyPort()).append("/proxyApi/account");
//			urls.add(sb.toString());
//		}
//
//		return urls;
//	}

}
