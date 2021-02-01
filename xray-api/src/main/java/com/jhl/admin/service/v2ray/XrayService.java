package com.jhl.admin.service.v2ray;


import com.google.gson.Gson;
import com.ljh.common.model.ProxyAccount;
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
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class XrayService {

	private final String uplinkFormat = "user>>>%s>>>traffic>>>uplink";
	private final String downlinkFormat = "user>>>%s>>>traffic>>>downlink";

	public void rmProxyAccount(String host, Integer port, ProxyAccount proxyAccount) {
		try {
			XrayApiClient client = XrayApiClient.getInstance(host, port);
			TypedMessage rmOp = TypedMessage.newBuilder().setType(RemoveUserOperation.getDescriptor().getFullName())
					.setValue(RemoveUserOperation.newBuilder().setEmail(proxyAccount.getEmail()).build().toByteString()).build();
			AlterInboundRequest req = AlterInboundRequest.newBuilder().setTag(proxyAccount.getInBoundTag()).setOperation(rmOp).build();
			client.getHandlerServiceBlockingStub().alterInbound(req);
			log.info("rmProxyAccount success:{}", proxyAccount.getEmail());
		} catch (Exception e) {
			if (e.getLocalizedMessage().contains("not found")) {
				log.info("rmProxyAccount already removed:{}", proxyAccount.getEmail());
				return;
			}
			log.error("rmProxyAccount error:{},{}", e.getLocalizedMessage(), new Gson().toJson(proxyAccount), e);
		}
	}

	public void addProxyAccount(String host, Integer port, ProxyAccount proxyAccount) {
		try {
			XrayApiClient client = XrayApiClient.getInstance(host, port);
			com.xray.proxy.vmess.Account account = com.xray.proxy.vmess.Account.newBuilder().setAlterId(proxyAccount.getAlterId()).setId(proxyAccount.getId())
					.setSecuritySettings(SecurityConfig.newBuilder().setType(SecurityType.AUTO).build()).build();

			TypedMessage AccountTypedMsg = TypedMessage.newBuilder().
					setType(com.xray.proxy.vmess.Account.getDescriptor().getFullName()
					).setValue(account.toByteString()).build();

			User user = User.newBuilder().setEmail(proxyAccount.getEmail()).setLevel(proxyAccount.getLevel()).setAccount(AccountTypedMsg).build();
			AddUserOperation addUserOperation = AddUserOperation.newBuilder().setUser(user).build();

			TypedMessage typedMessage = TypedMessage.newBuilder().setType(AddUserOperation.getDescriptor().getFullName())
					.setValue(addUserOperation.toByteString()).build();

			client.getHandlerServiceBlockingStub().alterInbound(AlterInboundRequest.newBuilder().setTag(proxyAccount.getInBoundTag()).setOperation(typedMessage).build());
			log.info("addProxyAccount success:{}", proxyAccount.getEmail());
		} catch (Exception e) {
			if (e.getLocalizedMessage().contains("already exists")) {
				log.info("addProxyAccount already exists:{}", proxyAccount.getEmail());
				return;
			}
			log.error("addProxyAccount error:{},{}", e.getLocalizedMessage(), new Gson().toJson(proxyAccount), e);
		}
	}

	// 获得用户流量
	public long getTraffic(String host, Integer port, ProxyAccount proxyAccount) {
		String q = String.format(downlinkFormat, proxyAccount.getEmail());
		GetStatsRequest req = GetStatsRequest
				.newBuilder()
				.setReset(true)
				.setName(q)
				.build();
		try {
			XrayApiClient client = XrayApiClient.getInstance(host, port);
			GetStatsResponse res = client.getStatsServiceBlockingStub().getStats(req);
			long t = res.getStat().getValue();
			log.info("获取用户流量: USER " + proxyAccount.getEmail() + " TRAFFIC " + t);
			return t;
		} catch (StatusRuntimeException e) {
			if (!e.getMessage().contains(q + " not found"))
				log.error("获取用户流量失败", e);
			return 0;
		}
	}

}
