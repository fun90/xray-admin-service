package com.jhl.admin.controller;

import com.jhl.admin.constant.ClientConstant;
import com.jhl.admin.constant.ProxyConstant;
import com.jhl.admin.constant.enumObject.WebsiteConfigEnum;
import com.jhl.admin.model.Account;
import com.jhl.admin.model.Server;
import com.jhl.admin.service.ServerConfigService;
import com.jhl.admin.service.SubscriptionService;
import com.jhl.admin.util.QuanxRuleParser;
import com.jhl.admin.util.SubscribeHelper;
import com.jhl.admin.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

	private final String[] targets = { "clash", "quanx", "surge", "loon", "shadowrocket" };

	/**
	 * 防暴力，防中间人篡改
	 *
	 * @param code  code
	 * @param target 客户端类型 {@link #targets}
	 * @param token md5(code+timestamp+api.auth)
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/subscribe/{code}", produces="text/plain;charset=UTF-8")
	public String subscribe(@PathVariable String code, String target, Integer type, Long timestamp, String token) {

		if (code == null || type == null || timestamp == null || token == null) throw new NullPointerException("参数错误");

		StringBuilder stringBuilder = new StringBuilder();
		StringBuilder tokenSrc = stringBuilder.append(code).append(timestamp).append(proxyConstant.getAuthPassword());
		if (!DigestUtils.md5Hex(tokenSrc.toString()).equals(token)) throw new RuntimeException("认证失败");

		String result;
		if (type == 0) {
			target = StringUtils.defaultString(target, ClientConstant.DEFAULT);
			result = subscriptionService.subscribe(code, target);
		} else {
			if (!StringUtils.equalsAny(target, targets)) {
				throw new IllegalArgumentException("target错误");
			}
			result = getConfigContent(code, target);
		}

		return result;
	}

	/**
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/subscribe/rules/{fileName}", produces="text/plain;charset=UTF-8")
	public String rules(@PathVariable String fileName, String target, String group) {
		String templatePath = getTemplatePath();

		if (StringUtils.equalsAny(target, "loon", "surge")) {
			return Utils.writeString(templatePath, "rules", fileName);
		} else if (StringUtils.equalsAny(target, "quanx")) {
			fileName = new String(Base64.decodeBase64(fileName));
			group = new String(Base64.decodeBase64(group));
			if (StringUtils.startsWithAny(fileName, "https://", "http://")) {
				return Utils.call(fileName, new QuanxRuleParser(clientConstant, group));
			} else {
				return Utils.writeString(templatePath, new QuanxRuleParser(clientConstant, group), "rules", fileName);
			}
		}

		return "不支持的target";
	}

	private String getConfigContent(String code, String target) {
		Map<String, Object> params = new HashMap<>();
		Account account = subscriptionService.findAccountByCode(code);
		params.put("account", account);

		List<Server> servers = subscriptionService.findServers(account, target);
		params.put("servers", servers);

		String rootUrl = serverConfigService.getServerConfig(WebsiteConfigEnum.SUBSCRIPTION_ADDRESS_PREFIX.getKey()).getValue();
		String subscriptionUrl = account.getSubscriptionUrl();
		params.put("M", new SubscribeHelper(target, rootUrl, subscriptionUrl));
		return templateMerge(target, params);
	}

	private VelocityEngine ve;
	private String templateMerge(String target, Map<String, Object> params) {
		String fileName = target + ".vm";
		if (ve == null) {
			//模板文件路径
			String templatePath = getTemplatePath();
			if (!Files.exists(Paths.get(templatePath, fileName))) {
				throw new RuntimeException(target + "的模板文件不存在");
			}
			ve = new VelocityEngine();
			ve.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, templatePath);
			ve.init();
		}
		Template template = ve.getTemplate(fileName, "UTF-8");
		VelocityContext data = new VelocityContext();
		params.forEach(data::put);
		try {
			StringWriter stringWriter = new StringWriter();
			template.merge(data, stringWriter);
			return stringWriter.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String getTemplatePath() {
		Path path = Paths.get(new ApplicationHome(getClass()).getSource().getParent(), "template");
		if (Files.exists(path)) {
			return path.toAbsolutePath().toString();
		}
		try {
			return ResourceUtils.getURL("classpath:template").getPath();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
