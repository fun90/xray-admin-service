package com.jhl.admin.constant;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Data
@ConfigurationProperties(prefix = "client")
public class ClientConstant {
	public static final String Clash = "clash";
	public static final String Clash2 = "clash2";
	public static final String QuanX = "quanx";
	public static final String Surge = "surge";
	public static final String Loon = "loon";
	public static final String Shadowrocket = "shadowrocket";
	public static final String DEFAULT = "shadowrocket";

	private Map<String, List<String>> supportProtocols;

	public ClientConstant() {
		this.supportProtocols = new HashMap<>();
		this.supportProtocols.put("clash", Stream.of("trojan", "vmess").collect(Collectors.toList()));
		this.supportProtocols.put("clash2", Stream.of("trojan", "vmess").collect(Collectors.toList()));
		this.supportProtocols.put("quanx", Stream.of("trojan", "vmess").collect(Collectors.toList()));
		this.supportProtocols.put("surge", Stream.of("trojan", "vmess").collect(Collectors.toList()));
		this.supportProtocols.put("loon", Stream.of("trojan", "vmess", "vless").collect(Collectors.toList()));
		this.supportProtocols.put("shadowrocket", Stream.of("trojan", "vmess", "vless").collect(Collectors.toList()));
	}
}
