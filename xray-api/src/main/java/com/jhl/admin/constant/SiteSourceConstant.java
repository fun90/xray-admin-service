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
@ConfigurationProperties(prefix = "site-source")
public class SiteSourceConstant {
	private String direct;
	private String proxy;
}
