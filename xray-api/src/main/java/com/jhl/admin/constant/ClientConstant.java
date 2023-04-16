package com.jhl.admin.constant;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
@ConfigurationProperties(prefix = "client")
public class ClientConstant {
	public static final List<ClientInfo> CLIENT_INFOS = new ArrayList<ClientInfo>() {{
		add(new ClientInfo("shadowrocket", "Shadowrocket"));
		add(new ClientInfo("clash", "Clash"));
		add(new ClientInfo("clash2", "Clash Premium"));
		add(new ClientInfo("clash3", "Clash.Meta"));
		add(new ClientInfo("loon", "Loon"));
		add(new ClientInfo("surge", "Surge 4"));
		add(new ClientInfo("quanx", "Quantumult X"));
	}};

	/**
	 * 默认客户端为第一个
	 */
	public static final ClientInfo DEFAULT = CLIENT_INFOS.get(0);

	public static final ClientInfo Shadowrocket = CLIENT_INFOS.get(0);
	public static final ClientInfo Clash = CLIENT_INFOS.get(1);
	public static final ClientInfo ClashPremium = CLIENT_INFOS.get(2);
	public static final ClientInfo ClashMeta = CLIENT_INFOS.get(3);
	public static final ClientInfo Loon = CLIENT_INFOS.get(4);
	public static final ClientInfo Surge = CLIENT_INFOS.get(5);
	public static final ClientInfo QuantumultX = CLIENT_INFOS.get(6);

	private List<ClientInfo> supportList = CLIENT_INFOS;

	public boolean isSupported(String client) {
		for (ClientInfo clientInfo : supportList) {
			if (client.startsWith(clientInfo.getValue())) {
				return true;
			}
		}
		return false;
	}

	@Data
	@NoArgsConstructor
	public static class ClientInfo {
		private String value;
		private String label;

		public ClientInfo(String value, String label) {
			this.value = value;
			this.label = label;
		}
	}
}
