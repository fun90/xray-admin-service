package com.fun90.admin.constant;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@ConfigurationProperties(prefix = "client")
public class ClientConstant {

	public static final ClientInfo Shadowrocket = new ClientInfo(1, "Shadowrocket", "clash3", Stream.of("vmess", "trojan", "vless", "hysteria", "hysteria2").collect(Collectors.toList()));
	public static final ClientInfo ClashForWindows = new ClientInfo(2, "Clash for Windows(废弃)", "clash", Stream.of("vmess", "trojan").collect(Collectors.toList()));
	public static final ClientInfo ClashForWindows2 = new ClientInfo(3, "Clash for Windows", "clash2", Stream.of("vmess", "trojan").collect(Collectors.toList()));
	public static final ClientInfo ClashVerge = new ClientInfo(4, "Clash Verge", "clash3", Stream.of("vmess", "trojan", "vless", "hysteria", "hysteria2").collect(Collectors.toList()));
	public static final ClientInfo ClashMeta = new ClientInfo(5, "Clash Meta", "clash3", Stream.of("vmess", "trojan", "vless", "hysteria", "hysteria2").collect(Collectors.toList()));
	public static final ClientInfo Loon = new ClientInfo(20, "Loon", "loon", Stream.of("vmess", "trojan").collect(Collectors.toList()));
	public static final ClientInfo Surge = new ClientInfo(21, "Surge", "Surge", Stream.of("vmess", "trojan").collect(Collectors.toList()));
	public static final ClientInfo QuantumultX = new ClientInfo(22, "Quantumult X", "quanx", Stream.of("vmess", "trojan").collect(Collectors.toList()));

	public static final Map<Integer, ClientInfo> CLIENT_MAP = new HashedMap<>() {{
		put(Shadowrocket.getId(), Shadowrocket);
		put(ClashForWindows.getId(), ClashForWindows);
		put(ClashForWindows2.getId(), ClashForWindows2);
		put(ClashVerge.getId(), ClashVerge);
		put(ClashMeta.getId(), ClashMeta);
		put(Loon.getId(), Loon);
		put(Surge.getId(), Surge);
		put(QuantumultX.getId(), QuantumultX);
	}};

	/**
	 * 默认客户端为Shadowrocket
	 */
	public static final ClientInfo DEFAULT = Shadowrocket;

	private List<ClientInfo> supportList;

	private List<String> supportApps;

	private List<ProtocolInfo> supportProtocols;

	public List<ClientInfo> getSupportList() {
		return supportList;
	}

	public void setSupportApps(List<Integer> supportApps) {
		if (CollectionUtils.isEmpty(supportApps)) {
			this.supportList = new ArrayList<>(CLIENT_MAP.values());
		} else {
			this.supportList = supportApps.stream().map(CLIENT_MAP::get).filter(Objects::nonNull).toList();
		}
	}

	public List<String> getSupportApps() {
		return supportApps;
	}

	public List<ProtocolInfo> getSupportProtocols() {
		return supportProtocols;
	}

	public void setSupportProtocols(List<ProtocolInfo> supportProtocols) {
		this.supportProtocols = supportProtocols;
	}

	public boolean isSupported(String target) {
		for (ClientInfo clientInfo : supportList) {
			if (target.startsWith(clientInfo.getTarget())) {
				return true;
			}
		}
		return false;
	}

	@Data
	@NoArgsConstructor
	public static class ClientInfo {
		private Integer id;
		private String app;
		private String target;
		private List<String> protocols;

		public ClientInfo(Integer id, String app, String target, List<String> protocols) {
			this.id = id;
			this.app = app;
			this.target = target;
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
