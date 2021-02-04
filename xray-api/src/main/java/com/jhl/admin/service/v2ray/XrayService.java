package com.jhl.admin.service.v2ray;


import com.google.gson.Gson;
import com.jhl.admin.model.ProxyAccount;
import com.jhl.admin.model.Server;
import com.xray.app.proxyman.command.AddUserOperation;
import com.xray.app.proxyman.command.AlterInboundRequest;
import com.xray.app.proxyman.command.RemoveUserOperation;
import com.xray.app.stats.command.GetStatsRequest;
import com.xray.app.stats.command.GetStatsResponse;
import com.xray.common.protocol.SecurityConfig;
import com.xray.common.protocol.SecurityType;
import com.xray.common.protocol.User;
import com.xray.common.serial.TypedMessage;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class XrayService {

	private final String uplinkFormat = "user>>>%s>>>traffic>>>uplink";
	private final String downlinkFormat = "user>>>%s>>>traffic>>>downlink";

	public void rmProxyAccount(ProxyAccount proxyAccount) {
		List<Server> servers = proxyAccount.getServers();
		servers.forEach(server -> {
			try {
					XrayApiClient client = XrayApiClient.getInstance(server.getV2rayIp(), server.getV2rayManagerPort());
					TypedMessage rmOp = TypedMessage.newBuilder().setType(RemoveUserOperation.getDescriptor().getFullName())
							.setValue(RemoveUserOperation.newBuilder().setEmail(proxyAccount.getEmail()).build().toByteString()).build();
					AlterInboundRequest req = AlterInboundRequest.newBuilder().setTag(server.getInboundTag()).setOperation(rmOp).build();
					client.getHandlerServiceBlockingStub().alterInbound(req);
					log.info("rmProxyAccount success:{}, protocol:{}", proxyAccount.getEmail(), server.getProtocol());
			} catch (Exception e) {
				if (StringUtils.contains(e.getLocalizedMessage(), "not found")) {
					log.info("rmProxyAccount already removed:{}, protocol:{}", proxyAccount.getEmail(), server.getProtocol());
					return;
				}
				log.error("rmProxyAccount error:{},{}", e.getLocalizedMessage(), new Gson().toJson(proxyAccount), e);
			}
		});
	}

	public void addProxyAccount(ProxyAccount proxyAccount) {
		List<Server> servers = proxyAccount.getServers();
		for (Server server : servers) {
			if ("vless".equalsIgnoreCase(server.getProtocol())) {
				addVLESSAccount(proxyAccount, server);
			} else if ("trojan".equalsIgnoreCase(server.getProtocol())) {
				addTrojanAccount(proxyAccount, server);
			} else {
				addVMESSAccount(proxyAccount, server);
			}
		}
	}

	private void addVMESSAccount(ProxyAccount proxyAccount, Server server) {
		try {
			XrayApiClient client = XrayApiClient.getInstance(server.getV2rayIp(), server.getV2rayManagerPort());
			com.xray.proxy.vmess.Account account = com.xray.proxy.vmess.Account.newBuilder().setAlterId(proxyAccount.getAlterId()).setId(proxyAccount.getId())
					.setSecuritySettings(SecurityConfig.newBuilder().setType(SecurityType.AUTO).build()).build();

			TypedMessage AccountTypedMsg = TypedMessage.newBuilder().
					setType(com.xray.proxy.vmess.Account.getDescriptor().getFullName()
					).setValue(account.toByteString()).build();

			User user = User.newBuilder().setEmail(proxyAccount.getEmail()).setLevel(proxyAccount.getLevel()).setAccount(AccountTypedMsg).build();
			AddUserOperation addUserOperation = AddUserOperation.newBuilder().setUser(user).build();

			TypedMessage typedMessage = TypedMessage.newBuilder().setType(AddUserOperation.getDescriptor().getFullName())
					.setValue(addUserOperation.toByteString()).build();

			client.getHandlerServiceBlockingStub().alterInbound(AlterInboundRequest.newBuilder().setTag(server.getInboundTag()).setOperation(typedMessage).build());
			log.info("addVMESSAccount success:{}", proxyAccount.getEmail());
		} catch (Exception e) {
			if (StringUtils.contains(e.getLocalizedMessage(), "already exists")) {
				log.info("addVMESSAccount already exists:{}", proxyAccount.getEmail());
				return;
			}
			log.error("addVMESSAccount error:{},{}", e.getLocalizedMessage(), new Gson().toJson(proxyAccount), e);
		}
	}

	private void addVLESSAccount(ProxyAccount proxyAccount, Server server) {
		try {
			XrayApiClient client = XrayApiClient.getInstance(server.getV2rayIp(), server.getV2rayManagerPort());
			com.xray.proxy.vless.Account account = com.xray.proxy.vless.Account.newBuilder().setId(proxyAccount.getId())
					.setEncryption("none").setFlow("xtls-rprx-direct").build();

			TypedMessage AccountTypedMsg = TypedMessage.newBuilder().
					setType(com.xray.proxy.vless.Account.getDescriptor().getFullName()
					).setValue(account.toByteString()).build();

			User user = User.newBuilder().setEmail(proxyAccount.getEmail()).setLevel(proxyAccount.getLevel()).setAccount(AccountTypedMsg).build();
			AddUserOperation addUserOperation = AddUserOperation.newBuilder().setUser(user).build();

			TypedMessage typedMessage = TypedMessage.newBuilder().setType(AddUserOperation.getDescriptor().getFullName())
					.setValue(addUserOperation.toByteString()).build();

			client.getHandlerServiceBlockingStub().alterInbound(AlterInboundRequest.newBuilder().setTag(server.getInboundTag()).setOperation(typedMessage).build());
			log.info("addVLESSAccount success:{}", proxyAccount.getEmail());
		} catch (Exception e) {
			if (StringUtils.contains(e.getLocalizedMessage(), "already exists")) {
				log.info("addVLESSAccount already exists:{}", proxyAccount.getEmail());
				return;
			}
			log.error("addProxyAccount error:{},{}", e.getLocalizedMessage(), new Gson().toJson(proxyAccount), e);
		}
	}

	private void addTrojanAccount(ProxyAccount proxyAccount, Server server) {
		try {
			XrayApiClient client = XrayApiClient.getInstance(server.getV2rayIp(), server.getV2rayManagerPort());
			com.xray.proxy.trojan.Account account = com.xray.proxy.trojan.Account.newBuilder().setPassword(proxyAccount.getId())
					.setFlow("xtls-rprx-direct").build();

			TypedMessage AccountTypedMsg = TypedMessage.newBuilder().
					setType(com.xray.proxy.vless.Account.getDescriptor().getFullName()
					).setValue(account.toByteString()).build();

			User user = User.newBuilder().setEmail(proxyAccount.getEmail()).setLevel(proxyAccount.getLevel()).setAccount(AccountTypedMsg).build();
			AddUserOperation addUserOperation = AddUserOperation.newBuilder().setUser(user).build();

			TypedMessage typedMessage = TypedMessage.newBuilder().setType(AddUserOperation.getDescriptor().getFullName())
					.setValue(addUserOperation.toByteString()).build();

			client.getHandlerServiceBlockingStub().alterInbound(AlterInboundRequest.newBuilder().setTag(server.getInboundTag()).setOperation(typedMessage).build());
			log.info("addTrojanAccount success:{}", proxyAccount.getEmail());
		} catch (Exception e) {
			if (StringUtils.contains(e.getLocalizedMessage(), "already exists")) {
				log.info("addTrojanAccount already exists:{}", proxyAccount.getEmail());
				return;
			}
			log.error("addTrojanAccount error:{},{}", e.getLocalizedMessage(), new Gson().toJson(proxyAccount), e);
		}
	}

	public long getDownlinkTraffic(String host, Integer port, String email) {
		return getTraffic(host, port, email, downlinkFormat);
	}

	public long getUplinkTraffic(String host, Integer port, String email) {
		return getTraffic(host, port, email, uplinkFormat);
	}

	// 获得用户流量
	private long getTraffic(String host, Integer port, String email, String format) {
		String q = String.format(format, email);
		GetStatsRequest req = GetStatsRequest
				.newBuilder()
				.setReset(true)
				.setName(q)
				.build();
		try {
			XrayApiClient client = XrayApiClient.getInstance(host, port);
			GetStatsResponse res = client.getStatsServiceBlockingStub().getStats(req);
			long t = res.getStat().getValue();
			log.info("获取用户流量: USER {}, TRAFFIC {}", q, t);
			return t;
		} catch (StatusRuntimeException e) {
			if (!e.getMessage().contains(q + " not found"))
				log.error("获取用户流量失败", e);
			return 0;
		}
	}
}
