package com.jhl.admin.constant;

import com.alibaba.fastjson.JSONObject;
import com.jhl.admin.util.Utils;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Component
@PropertySource("internal.properties")
@Getter
@Setter
@Slf4j
public class InternalConstant {
	@Autowired
	RestTemplate restTemplate;
	@Value("${app.githubURL}")
	String githubURL;
	@Value("${app.version}")
	private String version;

	@PostConstruct
	public void init() {

		new Thread(() -> {
			JSONObject forObject = restTemplate.getForObject(githubURL, JSONObject.class);
			String tagName = forObject.getString("tag_name");
			String lastVersion = StringUtils.removeStartIgnoreCase(tagName, "v");
			String body = forObject.getString("body").replaceAll("#", "");
			log.info("===========================================");
			log.info("欢迎使用 xray-admin-service");
			int r = Utils.compareVersion(version, lastVersion);
			if (r == 0) {
				log.info("当前运行的是最新版本: v{}", lastVersion);
			} else if (r == -1) {
				log.info("当前版本: v{}，可更新至最新版本：v{}", version, lastVersion);
			} else {
				log.info("当前版本: v{}", version);
			}
			log.info("===========================================");
		}).start();

	}
}
