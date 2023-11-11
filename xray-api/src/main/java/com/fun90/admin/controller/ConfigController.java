package com.fun90.admin.controller;

import com.alibaba.fastjson2.JSONArray;
import com.fun90.admin.constant.ClientConstant;
import com.fun90.admin.constant.enumObject.WebsiteConfigEnum;
import com.fun90.admin.cron.RulesCron;
import com.fun90.admin.interceptor.PreAuth;
import com.fun90.admin.model.ServerConfig;
import com.fun90.admin.service.ServerConfigService;
import com.fun90.admin.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class ConfigController {

	@Autowired
	ServerConfigService serverConfigService;
	@Autowired
	RulesCron rulesCron;
	@Autowired
	ClientConstant clientConstant;

	/**
	 * 支持的客户端列表
	 */
	@PreAuth("vip")
	@ResponseBody
	@GetMapping("/config/clients")
	public Result clients() {
		return Result.buildSuccess(clientConstant.getSupportList(), null);
	}

	/**
	 * 支持的协议列表
	 */
	@PreAuth("vip")
	@ResponseBody
	@GetMapping("/config/protocols")
	public Result protocols() {
		return Result.buildSuccess(clientConstant.getSupportProtocols(), null);
	}

	/**
	 * 账号等级
	 */
	@PreAuth("vip")
	@ResponseBody
	@GetMapping("/config/accountLevels")
	public Result accountLevels() {
		ServerConfig serverConfig = serverConfigService.getServerConfig(WebsiteConfigEnum.ACCOUNT_LEVEL_JSON.getKey());
		String json = serverConfig.getValue();
		JSONArray jsonArray = JSONArray.parseArray(json);
		return Result.buildSuccess(jsonArray, null);
	}

	/**
	 * 重新生成规则文件
	 */
	@PreAuth("admin")
	@ResponseBody
	@GetMapping("/config/generateRulesFile")
	public Result reloadProxyAccount() {
		rulesCron.execute();
		return Result.doSuccess();
	}
}
