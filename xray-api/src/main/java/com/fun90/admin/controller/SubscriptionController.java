package com.fun90.admin.controller;

import com.alibaba.fastjson2.JSON;
import com.fun90.admin.VO.ServerVO;
import com.fun90.admin.constant.ClientConstant;
import com.fun90.admin.constant.ProxyConstant;
import com.fun90.admin.constant.enumObject.WebsiteConfigEnum;
import com.fun90.admin.model.Account;
import com.fun90.admin.model.ServerConfig;
import com.fun90.admin.model.Subscription;
import com.fun90.admin.service.AccountService;
import com.fun90.admin.service.ServerConfigService;
import com.fun90.admin.service.ServerService;
import com.fun90.admin.service.SubscriptionService;
import com.fun90.admin.util.SubscriptionUrlUtil;
import com.fun90.admin.util.subscribe.RulesParserFactory;
import com.fun90.admin.util.subscribe.TemplateUtil;
import com.fun90.admin.util.subscribe.parser.IRulesParser;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import javax.servlet.http.HttpServletRequest;
import java.io.StringWriter;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class SubscriptionController {
	@Autowired
	private SubscriptionService subscriptionService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private ProxyConstant proxyConstant;
	@Autowired
	private ClientConstant clientConstant;
	@Autowired
	private RulesParserFactory rulesParserFactory;
	@Autowired
	ServerService serverService;
	@Autowired
	private ServerConfigService serverConfigService;
	@Autowired
	private HttpServletRequest request;

	/**
	 * 防暴力，防中间人篡改
	 *
	 * @param code  code
	 */
	@ResponseBody
	@RequestMapping(value = "/subscribe/{code}", produces="text/plain")
	public String subscribe(@PathVariable String code, @RequestParam(required = false) Map<String, String> map) {
		String timestamp = map.get("timestamp");
		String token = map.get("token");
		if (code == null || token == null || timestamp == null) throw new IllegalArgumentException("参数错误");

		String target = StringUtils.defaultString(map.get("target"), ClientConstant.DEFAULT.getTarget());
		if (!clientConstant.isSupported(target)) {
			throw new IllegalArgumentException("target错误");
		}

		StringBuilder stringBuilder = new StringBuilder();
		StringBuilder tokenSrc = stringBuilder.append(code).append(timestamp).append(proxyConstant.getAuthPassword());
		if (!DigestUtils.md5Hex(tokenSrc.toString()).equals(token)) throw new RuntimeException("认证失败");

		Subscription subscription = subscriptionService.findByCode(code);
		Account account = accountService.findById(subscription.getAccountId());
		return getConfigContext(account, code, map);
	}

	@ResponseBody
	@RequestMapping(value = "/subscribe2/{code}/{clientId}/{target}", produces="text/plain")
	public String subscribe2(@PathVariable String code, @PathVariable Integer clientId,
							 @RequestParam(required = false) Map<String, String> map) {
		Subscription subscription = subscriptionService.findByCode(code);
		Account account = accountService.findById(subscription.getAccountId());
		if (account == null) {
			throw new RuntimeException("认证失败");
		}

		// 兼容旧版
		String token = map.get("token");
		if (token != null) {
			String timestamp = map.get("timestamp");
			StringBuilder stringBuilder = new StringBuilder();
			StringBuilder tokenSrc = stringBuilder.append(code).append(timestamp).append(proxyConstant.getAuthPassword());
			if (!DigestUtils.md5Hex(tokenSrc.toString()).equals(token)) {
				throw new RuntimeException("认证失败");
			}
		}

		ClientConstant.ClientInfo client = ClientConstant.CLIENT_MAP.get(clientId);
        Map<String, String> vo = new HashMap<>(map);
		vo.put("clientId", client.getId() + "");
		vo.put("target", client.getTarget());
		vo.put("type", "1");
		String whitelist = map.get("whitelist");
		vo.put("whitelist", whitelist == null ? "ture" : whitelist);
		return getConfigContext(account, code, vo);
	}

	private String getConfigContext(Account account, String code, Map<String, String> map) {
		List<ServerVO> servers = serverService.queryByAccount(account).stream().map(o -> {
			ServerVO vo = o.toVO(ServerVO.class);
			vo.setJson(JSON.parseObject(vo.getProtocolField()));
			return vo;
		}).collect(Collectors.toList());

		Map<String, Object> params = new HashMap<>();
		params.put("account", account);
		params.put("servers", servers);
		params.put("Base64", Base64.class);
		params.put("URLEncoder", URLEncoder.class);
		params.put("JSON", JSON.class);
		params.put("lineSeparator", System.lineSeparator());
		ServerConfig debugToken = serverConfigService.getServerConfig(WebsiteConfigEnum.DEBUG_TOKEN.getKey());
		params.put("debugToken", debugToken.getValue());
		params.putAll(map);

		String rootUrl = SubscriptionUrlUtil.getPrefix(request, serverConfigService);
		params.put("rootUrl", rootUrl);
		String subscriptionUrl = account.getSubscriptionUrl();
		UriComponents configUri = ServletUriComponentsBuilder.fromUriString(subscriptionUrl)
				.replaceQueryParam("target", map.get("target"))
				.replaceQueryParam("type", 1)
				.replaceQueryParam("debug", map.get("debug"))
				.build();
		// 配置订阅地址
		String configUrl = rootUrl + configUri.toUriString();
		params.put("configUrl", configUrl);
		// 代理节点订阅地址
		UriComponents proxiesUri = ServletUriComponentsBuilder.fromUriString(subscriptionUrl)
				.replaceQueryParam("target", map.get("target"))
				.replaceQueryParam("type", 0)
				.replaceQueryParam("debug", map.get("debug"))
				.build();
		String proxiesUrl = rootUrl + proxiesUri.toUriString();
		params.put("proxiesUrl", proxiesUrl);

		if (map.get("type") == null || "0".equals(map.get("type"))) {
			return templateMerge("nodes/" + map.get("target"), params);
		} else {
			IRulesParser rulesParser = rulesParserFactory.get(map.get("target"));
			if (rulesParser != null) {
				params.put("rulesParser", rulesParser);
			}
			return templateMerge(map.get("target"), params);
		}
	}

	/**
	 * 规则解析
	 */
	@ResponseBody
	@RequestMapping(value = {"/subscribe/rules/{target}/{fileName}", "/subscribe/rules/{target}/{fileName}/{group}"}, produces="text/plain")
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
