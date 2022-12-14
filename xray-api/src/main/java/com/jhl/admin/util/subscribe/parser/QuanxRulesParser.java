package com.jhl.admin.util.subscribe.parser;

import com.jhl.admin.constant.ClientConstant;
import com.jhl.admin.util.Utils;
import com.jhl.admin.util.subscribe.TemplateUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class QuanxRulesParser implements IRulesParser {
    private final String[] excludeTypes = {"USER-AGENT", "AND", "URL-REGEX"};

    @Override
    public String getTarget() {
        return ClientConstant.QuanX;
    }

    @Override
    public String content(String fileName, String group) {
        fileName = new String(Base64.decodeBase64(Base64.decodeBase64(fileName)));
        group = new String(Base64.decodeBase64(Base64.decodeBase64(group)));
        String finalGroup = group;

        Function<String, String> function = line -> {
            if (StringUtils.isBlank(line)) {
                return "";
            }
            line = cleanLine(line);
            if (StringUtils.startsWithAny(line, excludeTypes)) {
                return "  #" + line + System.lineSeparator();
            }
            line = StringUtils.replace(line, "IP-CIDR6", "IP6-CIDR");
            return line + System.lineSeparator();
        };

        if (StringUtils.startsWithAny(fileName, "https://", "http://")) {
            return Utils.call(fileName, function);
        } else {
            return Utils.writeString(TemplateUtil.getTemplatePath(), function, "rules", fileName);
        }
    }

    private String cleanLine(String line) {
        return line.replaceAll("\\s//.*", "");
    }
}