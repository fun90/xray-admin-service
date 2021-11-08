package com.jhl.admin.controller;

import com.jhl.admin.constant.ClientConstant;
import com.jhl.admin.constant.ProxyConstant;
import com.jhl.admin.model.Account;
import com.jhl.admin.model.Server;
import com.jhl.admin.service.SubscriptionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
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
	private ProxyConstant proxyConstant;

	private final String[] targets = { "clash", "quanx", "surge", "loon", "shadowrocket" };

	/**
	 * 防暴力，防中间人篡改
	 *
	 * @param code  code
	 * @param target 客户端类型 {@link #targets}
	 * @param token md5(code+timestamp+api.auth)
	 * @return
	 */

	@RequestMapping(value = "/subscribe/{code}")
	public void subscribe(@PathVariable String code, String target, Integer type, Long timestamp, String token, HttpServletResponse response) throws IOException {

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

		byte[] bytes = result.getBytes();
		response.setHeader("Content-Length", bytes.length + "");
		response.setHeader("Content-Type", MediaType.TEXT_PLAIN_VALUE);
		response.setCharacterEncoding("UTF-8");
//		response.setHeader("Content-Type", MediaType.APPLICATION_OCTET_STREAM_VALUE);
		response.getOutputStream().write(bytes);
		response.flushBuffer();
	}

	private String getConfigContent(String code, String target) {
		Account account = subscriptionService.findAccountByCode(code);
		Map<String, Object> params = new HashMap<>();
		params.put("account", account);
		List<Server> servers = subscriptionService.findServers(account, target);
		params.put("servers", servers);
		return templateMerge(target, params);
	}

	private String templateMerge(String target, Map<String, Object> params) {
		//模板文件路径
		String templatePath = getTemplatePath();
		String fileName = target + ".vm";
		if (!Files.exists(Paths.get(templatePath, fileName))) {
			throw new RuntimeException(target + "的模板文件不存在");
		}

		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, templatePath);
		ve.init();
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
