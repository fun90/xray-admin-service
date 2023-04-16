package com.jhl.admin.cron;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.jhl.admin.constant.enumObject.WebsiteConfigEnum;
import com.jhl.admin.model.ServerConfig;
import com.jhl.admin.service.ServerConfigService;
import com.jhl.admin.util.subscribe.TemplateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.Executor;

@Slf4j
@Component
public class RulesCron {
    @Autowired
    private ServerConfigService serverConfigService;
    @Resource(name = "executor")
    Executor executor;

    @Scheduled(cron = "0 15 8 * * ?")
    public void execute() {
        log.info("===========================================");
        log.info("开始生成规则列表任务");
        ServerConfig serverConfig = serverConfigService.getServerConfig(WebsiteConfigEnum.RULE_SET_JSON.getKey());
        String json = serverConfig.getValue();
        Map<String, String> map = JSON.parseObject(json, new TypeReference<Map<String, String>>(){});

        executor.execute(() -> {
            map.forEach((fileName, url) -> {
                TemplateUtil.generate(url, "rules", fileName);
            });
        });
    }

}
