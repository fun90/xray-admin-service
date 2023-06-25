package com.jhl.admin.service.v2ray;


import com.jhl.admin.model.ProxyAccount;
import com.jhl.admin.model.Server;
import com.xray.app.log.command.RestartLoggerRequest;
import com.xray.app.log.command.RestartLoggerResponse;
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
				logError("rmProxyAccount error, protocol: " + server.getProtocol() + ", account: " + proxyAccount.getEmail(), server.getV2rayIp(), server.getV2rayManagerPort(), e);
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

	public void restartLogger(List<Server> servers) {
		for (Server server : servers) {
			XrayApiClient client = XrayApiClient.getInstance(server.getV2rayIp(), server.getV2rayManagerPort());
			RestartLoggerRequest request = RestartLoggerRequest.newBuilder().getDefaultInstanceForType();
			RestartLoggerResponse response = client.getLoggerServiceBlockingStub().restartLogger(request);
			log.info("RestartLoggerResponse: {}", response);
		}
	}

	private void addVMESSAccount(ProxyAccount proxyAccount, Server server) {
		try {
			XrayApiClient client = XrayApiClient.getInstance(server.getV2rayIp(), server.getV2rayManagerPort());
			com.xray.proxy.vmess.Account account = com.xray.proxy.vmess.Account.newBuilder().setId(proxyAccount.getId())
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
			logError("addVMESSAccount error, protocol: " + server.getProtocol() + ", account: " + proxyAccount.getEmail(), server.getV2rayIp(), server.getV2rayManagerPort(), e);
		}
	}

	private void addVLESSAccount(ProxyAccount proxyAccount, Server server) {
		try {
			XrayApiClient client = XrayApiClient.getInstance(server.getV2rayIp(), server.getV2rayManagerPort());
			com.xray.proxy.vless.Account account = com.xray.proxy.vless.Account.newBuilder().setId(proxyAccount.getId())
					.setFlow("xtls-rprx-vision").build();

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
			logError("addProxyAccount error, protocol: " + server.getProtocol() + ", account: " + proxyAccount.getEmail(), server.getV2rayIp(), server.getV2rayManagerPort(), e);
		}
	}

	private void addTrojanAccount(ProxyAccount proxyAccount, Server server) {
		try {
			XrayApiClient client = XrayApiClient.getInstance(server.getV2rayIp(), server.getV2rayManagerPort());
			com.xray.proxy.trojan.Account account = com.xray.proxy.trojan.Account.newBuilder().setPassword(proxyAccount.getId()).build();

			TypedMessage AccountTypedMsg = TypedMessage.newBuilder().
					setType(com.xray.proxy.trojan.Account.getDescriptor().getFullName()
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
			logError("addTrojanAccount error, protocol: " + server.getProtocol() + ", account: " + proxyAccount.getEmail(), server.getV2rayIp(), server.getV2rayManagerPort(), e);
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
//			log.info("获取用户流量: USER {}, TRAFFIC {}", q, t);
			return t;
		} catch (StatusRuntimeException e) {
			if (!e.getMessage().contains(q + " not found"))
				logError("获取用户流量失败", host, port, e);
			return 0;
		}
	}

	private void logError(String msg, String host, Integer port, Exception e) {
		if (e.getMessage().equals("UNAVAILABLE: io exception")) {
			log.error(msg + ", {}:{}, 错误信息: {}", host, port, e.getMessage());
		} else {
			log.error(msg + ", {}:{}, 错误信息: {}", host, port, e.getMessage(), e);
		}
	}
}
