package com.fun90.admin.constant;

import lombok.Data;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "proxy")
public class ProxyConstant {
	String authPassword;
	String subscriptionTemplate;
	String authPasswordMD5;

	public String getAuthPasswordMD5() {
		if (authPasswordMD5 == null) {
			authPasswordMD5 = DigestUtils.md5Hex(authPassword);
		}
		return authPasswordMD5;
	}
}
