package com.fun90.admin.constant;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@ConfigurationProperties(prefix = "client")
public class ClientConstant {
	public static final List<ClientInfo> CLIENT_INFOS = new ArrayList<>() {{
		add(new ClientInfo("shadowrocket", "Shadowrocket", Stream.of("VMess", "Trojan", "VLESS", "Hysteria", "Hysteria2").collect(Collectors.toList())));
		add(new ClientInfo("clash", "Clash", Stream.of("VMess", "Trojan").collect(Collectors.toList())));
		add(new ClientInfo("clash2", "Clash Premium", Stream.of("VMess", "Trojan").collect(Collectors.toList())));
		add(new ClientInfo("clash3", "Clash.Meta", Stream.of("VMess", "Trojan", "VLESS", "Hysteria", "Hysteria2").collect(Collectors.toList())));
		add(new ClientInfo("loon", "Loon", Stream.of("VMess", "Trojan").collect(Collectors.toList())));
		add(new ClientInfo("surge", "Surge 4", Stream.of("VMess", "Trojan").collect(Collectors.toList())));
		add(new ClientInfo("quanx", "Quantumult X", Stream.of("VMess", "Trojan").collect(Collectors.toList())));
	}};

	public static final ClientInfo Shadowrocket = CLIENT_INFOS.get(0);
	public static final ClientInfo Clash = CLIENT_INFOS.get(1);
	public static final ClientInfo ClashPremium = CLIENT_INFOS.get(2);
	public static final ClientInfo ClashMeta = CLIENT_INFOS.get(3);
	public static final ClientInfo Loon = CLIENT_INFOS.get(4);
	public static final ClientInfo Surge = CLIENT_INFOS.get(5);
	public static final ClientInfo QuantumultX = CLIENT_INFOS.get(6);

	/**
	 * 默认客户端为Shadowrocket
	 */
	public static final ClientInfo DEFAULT = Shadowrocket;

	private List<ClientInfo> supportList;

	private List<ProtocolInfo> supportProtocols;

	public List<ClientInfo> getSupportList() {
		return supportList;
	}

	public void setSupportList(List<ClientInfo> supportList) {
		this.supportList = supportList;
	}

	public List<ProtocolInfo> getSupportProtocols() {
		return supportProtocols;
	}

	public void setSupportProtocols(List<ProtocolInfo> supportProtocols) {
		this.supportProtocols = supportProtocols;
	}

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
		private List<String> protocols;

		public ClientInfo(String value, String label, List<String> protocols) {
			this.value = value;
			this.label = label;
			this.protocols = protocols;
		}
	}

	@Data
	@NoArgsConstructor
	public static class ProtocolInfo {
		private String value;
		private String label;

		public ProtocolInfo(String value, String label) {
			this.value = value;
			this.label = label;
		}
	}
}
