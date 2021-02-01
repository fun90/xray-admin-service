package com.jhl.admin.service.v2ray;


import com.google.common.collect.Lists;
import com.jhl.admin.entity.V2rayAccount;
import com.jhl.admin.model.Account;
import com.jhl.admin.model.Server;
import com.ljh.common.model.ProxyAccount;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class V2RayProxyEvent implements ProxyEvent {
	private XrayService xrayService;
	private Server server;
	private Account account;
	private String email;
	private String event;
	private V2rayAccountService v2rayAccountService;

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
			xrayService.rmProxyAccount(proxyAccount.getV2rayHost(), proxyAccount.getV2rayManagerPort(), proxyAccount);
		} catch (Exception e) {
			log.error("rmAccount error :{}", e.getLocalizedMessage());
		}
	}

	public void createEvent() {
		ProxyAccount proxyAccount = buildProxyAccount();
		try {
			if (proxyAccount == null) return;
			xrayService.addProxyAccount(proxyAccount.getV2rayHost(), proxyAccount.getV2rayManagerPort(), proxyAccount);
		} catch (Exception e) {
			log.error("addAccount error :{}", e.getLocalizedMessage());
		}
	}

	public ProxyAccount buildProxyAccount() {
		ProxyAccount proxyAccount = new ProxyAccount();
		//V2rayAccount v2rayAccount = JSON.parseObject(account.getContent(), V2rayAccount.class);
		String id
				= account.getUuid() == null ?
				v2rayAccountService.buildV2rayAccount(Lists.newArrayList(server), account).get(0).getId()
				: account.getUuid();
		proxyAccount.setAccountId(account.getId());
		proxyAccount.setAccountNo(account.getAccountNo());
		proxyAccount.setAlterId(account.getMaxConnection());
		proxyAccount.setDownTrafficLimit(account.getSpeed());
		proxyAccount.setEmail(email);
		proxyAccount.setId(id);
		proxyAccount.setInBoundTag(server.getInboundTag());
		proxyAccount.setMaxConnection(account.getMaxConnection());
		proxyAccount.setUpTrafficLimit(account.getSpeed());
		proxyAccount.setV2rayHost(server.getV2rayIp());
		proxyAccount.setV2rayPort(server.getV2rayPort());
		proxyAccount.setV2rayManagerPort(server.getV2rayManagerPort());
		proxyAccount.setHost(server.getClientDomain());
		proxyAccount.setProxyIp(server.getProxyIp());
		return proxyAccount;
	}

	public List<String> buildProxyServerUrl() {
		String[] proxyIps = server.getProxyIp().split(",");
		List<String> urls = Lists.newArrayList();
		for (String proxyIp : proxyIps) {
			StringBuilder sb = new StringBuilder("http://");
			sb.append(proxyIp).append(":").append(server.getProxyPort()).append("/proxyApi/account");
			urls.add(sb.toString());
		}

		return urls;
	}

}
