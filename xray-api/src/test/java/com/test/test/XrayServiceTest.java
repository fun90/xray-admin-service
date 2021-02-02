package com.test.test;

import com.jhl.admin.model.Server;
import com.jhl.admin.service.v2ray.XrayService;
import com.jhl.admin.model.ProxyAccount;

import java.util.ArrayList;
import java.util.List;

public class XrayServiceTest {
	static String API_ADDRESS = "127.0.0.1";
	static int API_PORT = 62789;
	static int LEVEL = 0;
	static String EMAIL = "congzi@live.com";
	static String UUID = "d1de3d8c-5253-4ddd-8c4b-3edde7625f47";
	static int ALTERID = 64;

	public static void main(String[] args) {
//		System.out.println(client);

		ProxyAccount proxyAccount = new ProxyAccount();
		proxyAccount.setAlterId(ALTERID);
		proxyAccount.setId(UUID);
		proxyAccount.setEmail(EMAIL);
		proxyAccount.setLevel(LEVEL);
		List<Server> servers = new ArrayList<>();
		servers.add(Server.builder().inboundTag("vless_tcp_xtls").protocol("VLESS").v2rayIp(API_ADDRESS).v2rayManagerPort(API_PORT).build());
		servers.add(Server.builder().inboundTag("vmess_ws")/*.protocol("VLESS")*/.v2rayIp(API_ADDRESS).v2rayManagerPort(API_PORT).build());
		proxyAccount.setServers(servers);
//		proxyAccount.setInBoundTag(INBOUND_TAG);
//		proxyAccount.setV2rayHost();
//		String json = "{\"accountId\":2,\"host\":\"vui.fun90.com\",\"accountNo\":\"wkfxv0n\",\"id\":\"05bbb95f-6bfd-9603-e3df-2022bffec302\",\"alterId\":64,\"level\":0,\"email\":\"congzi@live.com\",\"inBoundTag\":\"6001\",\"upTrafficLimit\":1024000,\"downTrafficLimit\":1024000,\"maxConnection\":64,\"v2rayHost\":\"64.64.235.96\",\"v2rayPort\":6001,\"v2rayManagerPort\":62789,\"proxyIp\":\"127.0.0.1\"}";
//		ProxyAccount proxyAccount = JSON.parseObject(json, ProxyAccount.class);

		XrayService xrayService = new XrayService();

		xrayService.addProxyAccount(proxyAccount);

		xrayService.rmProxyAccount(proxyAccount);

//		xrayService.getTraffic(API_ADDRESS, API_PORT, proxyAccount);
	}


}
