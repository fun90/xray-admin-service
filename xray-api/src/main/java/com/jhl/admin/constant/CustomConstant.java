package com.jhl.admin.constant;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Data
@ConfigurationProperties(prefix = "custom")
public class CustomConstant {
	List<String> myExternalServers = Collections.emptyList();
	List<String> externalServers = Collections.emptyList();
}
