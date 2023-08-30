package com.fun90.admin.util.subscribe;

import com.fun90.admin.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class TemplateUtil {
    public static String getTemplatePath() {
        Path path = Paths.get(new ApplicationHome(TemplateUtil.class).getSource().getParent(), "template");
        if (Files.exists(path)) {
            return path.toAbsolutePath().toString();
        }
        try {
            return ResourceUtils.getURL("classpath:template").getPath();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void generate(List<String> sites, String directory, String name) {
        log.info("正在读取从{}读取网址列表", sites);
        List<String> lines = new ArrayList<>();
        for (String site : sites) {
            Utils.call(site, line -> {
                if (StringUtils.isBlank(line)) {
                    return;
                }
                if (lines.contains(line)) {
                    log.info("忽略重复规则：{}", line);
                    return;
                }
                lines.add(line + System.lineSeparator());
            });
        }
        Path tmpPath = Paths.get(TemplateUtil.getTemplatePath(), directory, name + ".tmp.list");
        try {
            log.info("正在将规则列表写入临时文件：{}", tmpPath);
            Files.write(tmpPath, String.join("", lines).getBytes(StandardCharsets.UTF_8));
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
