package com.jhl.admin.constant;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
	public static final String Clash3 = "clash3";
	public static final String QuanX = "quanx";
	public static final String Surge = "surge";
	public static final String Loon = "loon";
	public static final String Shadowrocket = "shadowrocket";
	public static final String DEFAULT = "shadowrocket";

	private List<String> supported = new ArrayList<>();

	public ClientConstant() {
		this.supported.add(Clash);
		this.supported.add(Clash2);
		this.supported.add(Clash3);
		this.supported.add(QuanX);
		this.supported.add(Surge);
		this.supported.add(Loon);
		this.supported.add(Shadowrocket);
	}
}
