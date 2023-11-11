package com.fun90.admin.service.v2ray;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.fun90.admin.model.Account;
import com.fun90.admin.model.Server;
import com.fun90.admin.service.ServerService;
import com.fun90.admin.util.Utils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class Hysteria2ProxyEvent implements ProxyEvent {
	private String event;
	private Account account;
	private ServerService serverService;

	@Override
	public String getEvent() {
		return event;
	}

	public void updateEvent() {
		createEvent();
	}

	public void rmEvent() {
		List<Server> servers = serverService.queryHysteria2Servers(account);
		for (Server server : servers) {
			JSONObject serverJson = JSON.parseObject(server.getProtocolField());
			try {
				Utils.call("http://" + server.getV2rayIp()+ ":" + server.getV2rayManagerPort() + "/kick", serverJson.getString("auth"), null);
			} catch (Exception e) {
				log.error("Hysteria2踢出用户发生异常，错误信息：{}, 账号：{}", e.getMessage(), account.getAccountNo(), e);
			}
		}
	}

	public void createEvent() {

	}


}
