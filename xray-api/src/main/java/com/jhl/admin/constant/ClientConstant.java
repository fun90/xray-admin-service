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
	public static final String DEFAULT = "shadowrocket";
	private Map<String, List<String>> supportProtocols;
	private Map<String, String> quanxRuleTypes;
	private Map<String, List<String>> excludeRuleTypes;

	public ClientConstant() {
		this.supportProtocols = new HashMap<>();
		this.supportProtocols.put("clash", Stream.of("trojan", "vmess").collect(Collectors.toList()));
		this.supportProtocols.put("quanx", Stream.of("trojan", "vmess").collect(Collectors.toList()));
		this.supportProtocols.put("surge", Stream.of("trojan", "vmess").collect(Collectors.toList()));
		this.supportProtocols.put("loon", Stream.of("trojan", "vmess", "vless").collect(Collectors.toList()));
		this.supportProtocols.put("shadowrocket", Stream.of("trojan", "vmess", "vless").collect(Collectors.toList()));

		this.quanxRuleTypes = new HashMap<>();
		this.quanxRuleTypes.put("IP-CIDR6", "IP6-CIDR");

		this.excludeRuleTypes = new HashMap<>();
		this.excludeRuleTypes.put("quanx", Stream.of("USER-AGENT", "AND", "URL-REGEX").collect(Collectors.toList()));
		this.excludeRuleTypes.put("clash", Stream.of("USER-AGENT", "AND", "URL-REGEX").collect(Collectors.toList()));
		this.excludeRuleTypes.put("shadowrocket", Stream.of("USER-AGENT", "AND", "URL-REGEX", "IP-CIDR6").collect(Collectors.toList()));
	}
}
