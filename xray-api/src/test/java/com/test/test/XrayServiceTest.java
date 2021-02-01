package com.test.test;

import com.jhl.admin.service.v2ray.XrayService;
import com.ljh.common.model.ProxyAccount;

public class XrayServiceTest {
//	static String API_ADDRESS = "64.64.235.96";
//	static String API_ADDRESS = "10.211.55.20";
	static String API_ADDRESS = "127.0.0.1";
	static int API_PORT = 62789;
	static String INBOUND_TAG = "vmess_ws";
	static int LEVEL = 0;
//	static String EMAIL = "test@gmail.com";
//	static String UUID = "34b79488-f4aa-4e6c-9bb0-953e010b7737";
	static String EMAIL = "congzi@live.com";
	static String UUID = "05bbb95f-6bfd-9603-e3df-2022bffec302";
	static int ALTERID = 64;

	public static void main(String[] args) {
//		System.out.println(client);

		ProxyAccount proxyAccount = new ProxyAccount();
		proxyAccount.setAlterId(ALTERID);
		proxyAccount.setId(UUID);
		proxyAccount.setEmail(EMAIL);
		proxyAccount.setLevel(LEVEL);
		proxyAccount.setInBoundTag(INBOUND_TAG);
//		proxyAccount.setV2rayHost();
//		String json = "{\"accountId\":2,\"host\":\"vui.fun90.com\",\"accountNo\":\"wkfxv0n\",\"id\":\"05bbb95f-6bfd-9603-e3df-2022bffec302\",\"alterId\":64,\"level\":0,\"email\":\"congzi@live.com\",\"inBoundTag\":\"6001\",\"upTrafficLimit\":1024000,\"downTrafficLimit\":1024000,\"maxConnection\":64,\"v2rayHost\":\"64.64.235.96\",\"v2rayPort\":6001,\"v2rayManagerPort\":62789,\"proxyIp\":\"127.0.0.1\"}";
//		ProxyAccount proxyAccount = JSON.parseObject(json, ProxyAccount.class);


		XrayService xrayService = new XrayService();
		xrayService.addProxyAccount(API_ADDRESS, API_PORT, proxyAccount);
//		xrayService.rmProxyAccount(API_ADDRESS, API_PORT, proxyAccount);
//		xrayService.getTraffic(API_ADDRESS, API_PORT, proxyAccount);
	}


}
