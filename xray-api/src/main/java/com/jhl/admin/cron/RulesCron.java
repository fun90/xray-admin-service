package com.jhl.admin.cron;

import com.jhl.admin.constant.RulesSourceConstant;
import com.jhl.admin.util.Utils;
import com.jhl.admin.util.subscribe.TemplateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;

@Slf4j
@Component
public class RulesCron {
    @Autowired
    private RulesSourceConstant rulesSourceConstant;

    @Scheduled(cron = "0 15 8 * * ?")
    public void execute() {
        log.info("===========================================");
        log.info("开始生成规则列表任务");
        Map<String, String> map = rulesSourceConstant.getUrlMap();
        map.forEach((fileName, url) -> {
            generate(url, "rules", fileName);
        });
    }

    private void generate(String site, String directory, String name) {
        log.info("正在读取从{}读取网址列表", site);
        String content = Utils.call(site, line -> {
            if (StringUtils.isBlank(line)) {
                return "";
            }
            return line + System.lineSeparator();
        });
        Path tmpPath = Paths.get(TemplateUtil.getTemplatePath(), directory, name + ".tmp.list");
        try {
            log.info("正在将规则列表写入临时文件：{}", tmpPath);
            Files.write(tmpPath, content.getBytes(StandardCharsets.UTF_8));
            Path targetPath = Paths.get(TemplateUtil.getTemplatePath(), directory, name + ".list");
            log.info("正在将临时文件移动至{}", targetPath);
            Files.move(tmpPath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            log.info("生成规则列表文件成功");
        } catch (IOException e) {
            log.error("生成规则列表文件异常：{}", e.getMessage(), e);
        }
        log.info("===========================================");
    }
}
