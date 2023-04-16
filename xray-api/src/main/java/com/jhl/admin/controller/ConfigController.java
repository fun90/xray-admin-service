package com.jhl.admin.controller;

import com.alibaba.fastjson.JSONArray;
import com.jhl.admin.constant.ClientConstant;
import com.jhl.admin.constant.enumObject.WebsiteConfigEnum;
import com.jhl.admin.cron.RulesCron;
import com.jhl.admin.interceptor.PreAuth;
import com.jhl.admin.model.ServerConfig;
import com.jhl.admin.service.ServerConfigService;
import com.ljh.common.model.Result;
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

	/**
	 * 支持的客户端列表
	 */
	@PreAuth("vip")
	@ResponseBody
	@GetMapping("/config/clients")
	public Result clients() {
		return Result.buildSuccess(ClientConstant.CLIENT_INFOS, null);
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
