package com.jhl.admin.constant;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
@Data
@ConfigurationProperties(prefix = "client")
public class ClientConstant {
	public static final String DEFAULT = "shadowrocket";
	Map<String, List<String>> supportProtocols = Collections.emptyMap();
}
