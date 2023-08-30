package com.fun90.admin.controller;

import com.alibaba.fastjson2.JSON;
import com.fun90.admin.VO.SubscribeVO;
import com.fun90.admin.constant.ClientConstant;
import com.fun90.admin.constant.ProxyConstant;
import com.fun90.admin.model.Account;
import com.fun90.admin.model.Server;
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
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

@Slf4j
@Controller
public class SubscriptionController {
	@Autowired
	private SubscriptionService subscriptionService;
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
	public String subscribe(@PathVariable String code, SubscribeVO vo) {

		if (code == null || vo.getTimestamp() == null || vo.getToken() == null) throw new IllegalArgumentException("参数错误");

		String target = StringUtils.defaultString(vo.getTarget(), ClientConstant.DEFAULT.getValue());
		if (!clientConstant.isSupported(target)) {
			throw new IllegalArgumentException("target错误");
		}

		StringBuilder stringBuilder = new StringBuilder();
		StringBuilder tokenSrc = stringBuilder.append(code).append(vo.getTimestamp()).append(proxyConstant.getAuthPassword());
		if (!DigestUtils.md5Hex(tokenSrc.toString()).equals(vo.getToken())) throw new RuntimeException("认证失败");

		return getConfigContext(code, vo);
	}

	@ResponseBody
	@RequestMapping(value = "/subscribe3/{code}/duoyu", produces="text/plain")
	public String subscribe3(@PathVariable String code) {
		SubscribeVO vo = new SubscribeVO();
		vo.setTarget("clash3");
		vo.setType(1);
		vo.setWhitelist(true);
		return getConfigContext(code, vo);
	}

	private String getConfigContext(String code, SubscribeVO vo) {
		Account account = subscriptionService.findAccountByCode(code);
		List<Server> servers = serverService.queryByAccount(account);

		Map<String, Object> params = new HashMap<>();
		params.put("account", account);
		params.put("servers", servers);
		params.put("Base64", Base64.class);
		params.put("URLEncoder", URLEncoder.class);
		params.put("JSON", JSON.class);
		params.put("lineSeparator", System.lineSeparator());
		BeanMap beanMap = BeanMap.create(vo);
		params.putAll(beanMap);
		if (vo.getType() == null || vo.getType() == 0) {
			return templateMerge("nodes/" + vo.getTarget(), params);
		} else {
			IRulesParser rulesParser = rulesParserFactory.get(vo.getTarget());
			if (rulesParser != null) {
				params.put("rulesParser", rulesParser);
			}


			String rootUrl = SubscriptionUrlUtil.getPrefix(request, serverConfigService);
			params.put("rootUrl", rootUrl);

			String subscriptionUrl = account.getSubscriptionUrl();

			UriComponents configUri = ServletUriComponentsBuilder.fromUriString(subscriptionUrl)
					.replaceQueryParam("target", vo.getTarget())
					.replaceQueryParam("type", 1)
					.build();
			// 配置订阅地址
			String configUrl = rootUrl + configUri.toUriString();
			params.put("configUrl", configUrl);

			// 代理节点订阅地址
			UriComponents proxiesUri = ServletUriComponentsBuilder.fromUriString(subscriptionUrl)
					.replaceQueryParam("target", vo.getTarget())
					.replaceQueryParam("type", 0)
					.build();
			String proxiesUrl = rootUrl + proxiesUri.toUriString();
			params.put("proxiesUrl", proxiesUrl);

			return templateMerge(vo.getTarget(), params);
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
