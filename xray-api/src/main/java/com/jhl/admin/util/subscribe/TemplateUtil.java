package com.jhl.admin.util.subscribe;

import org.springframework.boot.system.ApplicationHome;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
}
