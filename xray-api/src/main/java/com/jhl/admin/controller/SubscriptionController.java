package com.jhl.admin.controller;

import com.alibaba.fastjson.JSON;
import com.jhl.admin.constant.ClientConstant;
import com.jhl.admin.constant.ProxyConstant;
import com.jhl.admin.constant.enumObject.WebsiteConfigEnum;
import com.jhl.admin.model.Account;
import com.jhl.admin.model.Server;
import com.jhl.admin.service.ServerConfigService;
import com.jhl.admin.service.ServerService;
import com.jhl.admin.service.SubscriptionService;
import com.jhl.admin.util.subscribe.RulesParserFactory;
import com.jhl.admin.util.subscribe.TemplateUtil;
import com.jhl.admin.util.subscribe.parser.IRulesParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.io.StringWriter;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class SubscriptionController {
	@Autowired
	private SubscriptionService subscriptionService;
	@Autowired
	private ServerConfigService serverConfigService;
	@Autowired
	private ProxyConstant proxyConstant;
	@Autowired
	private ClientConstant clientConstant;
	@Autowired
	private RulesParserFactory rulesParserFactory;
	@Autowired
	ServerService serverService;

	/**
	 * 防暴力，防中间人篡改
	 *
	 * @param code  code
	 * @param target 客户端类型: "clash", "clash2", "quanx", "surge", "loon", "shadowrocket"
	 * @param token md5(code+timestamp+api.auth)
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/subscribe/{code}", produces="text/plain;charset=UTF-8")
	public String subscribe(@PathVariable String code, String target, Integer type, Long timestamp, String token) {

		if (code == null || type == null || timestamp == null || token == null) throw new IllegalArgumentException("参数错误");

		target = StringUtils.defaultString(target, ClientConstant.DEFAULT);
		if (!clientConstant.getSupported().contains(target)) {
			throw new IllegalArgumentException("target错误");
		}

		StringBuilder stringBuilder = new StringBuilder();
		StringBuilder tokenSrc = stringBuilder.append(code).append(timestamp).append(proxyConstant.getAuthPassword());
		if (!DigestUtils.md5Hex(tokenSrc.toString()).equals(token)) throw new RuntimeException("认证失败");

		Account account = subscriptionService.findAccountByCode(code);
		Short level = account.getLevel();
		List<Server> servers = serverService.listByLevel(level);

		if (type == 0) {
			Map<String, Object> params = new HashMap<>();
			params.put("account", account);
			params.put("servers", servers);
			params.put("Base64", Base64.class);
			params.put("URLEncoder", URLEncoder.class);
			params.put("JSON", JSON.class);
			params.put("lineSeparator", System.lineSeparator());
			return templateMerge("nodes/" + target, params);

		} else {
			Map<String, Object> params = new HashMap<>();
			params.put("account", account);
			params.put("servers", servers);

			IRulesParser rulesParser = rulesParserFactory.get(target);
			if (rulesParser != null) {
				params.put("rulesParser", rulesParser);
			}


			String rootUrl = serverConfigService.getServerConfig(WebsiteConfigEnum.SUBSCRIPTION_ADDRESS_PREFIX.getKey()).getValue();
			params.put("rootUrl", rootUrl);

			String subscriptionUrl = account.getSubscriptionUrl();

			UriComponents configUri = ServletUriComponentsBuilder.fromUriString(subscriptionUrl)
					.replaceQueryParam("target", target)
					.replaceQueryParam("type", 1)
					.build();
			// 配置订阅地址
			String configUrl = rootUrl + configUri.toUriString();
			params.put("configUrl", configUrl);

			// 代理节点订阅地址
			UriComponents proxiesUri = ServletUriComponentsBuilder.fromUriString(subscriptionUrl)
					.replaceQueryParam("target", target)
					.replaceQueryParam("type", 0)
					.build();
			String proxiesUrl = rootUrl + proxiesUri.toUriString();
			params.put("proxiesUrl", proxiesUrl);

			return templateMerge(target, params);
		}
	}

	/**
	 * 规则解析
	 */
	@ResponseBody
	@RequestMapping(value = {"/subscribe/rules/{target}/{fileName}", "/subscribe/rules/{target}/{fileName}/{group}"}, produces="text/plain;charset=UTF-8")
	public String rules(@PathVariable String target, @PathVariable String fileName,  @PathVariable(required = false) String group) {
		if (!rulesParserFactory.contains(target)) {
			throw new IllegalArgumentException("target错误");
		}
		return rulesParserFactory.get(target).content(fileName, group);
	}

	private VelocityEngine ve;
	private String templateMerge(String target, Map<String, Object> params) {
		String fileName = target + ".vm";
		if (ve == null) {
			//模板文件路径
			String templatePath = TemplateUtil.getTemplatePath();
			if (!Files.exists(Paths.get(templatePath, fileName))) {
				throw new RuntimeException(target + "的模板文件不存在");
			}
			ve = new VelocityEngine();
			ve.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, templatePath);
			ve.init();
		}
		Template template = ve.getTemplate(fileName, "UTF-8");
		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("currentDateTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		params.forEach(velocityContext::put);
		try {
			StringWriter stringWriter = new StringWriter();
			template.merge(velocityContext, stringWriter);
			return stringWriter.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
