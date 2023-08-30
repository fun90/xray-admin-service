package com.fun90.admin.util.subscribe.parser;

import com.fun90.admin.constant.ClientConstant;
import com.fun90.admin.util.Utils;
import com.fun90.admin.util.subscribe.TemplateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class ShadowrocketRulesParser implements IRulesParser {
    private final String[] excludeTypes = {"AND", "URL-REGEX", "IP-CIDR6"};

    @Override
    public String getTarget() {
        return ClientConstant.Shadowrocket.getValue();
    }

    @Override
    public String content(String fileName, String group) {
        StringBuilder builder = new StringBuilder();
        Consumer<String> function = line -> {
            if (StringUtils.isBlank(line)) {
                return;
            }
            if (line.startsWith("#")) {
                builder.append(line).append(System.lineSeparator());
            }
            line = cleanLine(line);
            if (StringUtils.startsWithAny(line, excludeTypes)) {
//                return "  #" + line + System.lineSeparator();
                return;
            }
            builder.append(line).append(",").append(group).append(System.lineSeparator());
        };

        if (StringUtils.startsWithAny(fileName, "https://", "http://")) {
            Utils.call(fileName, function);
            return builder.toString();
        } else {
            Utils.readLine(TemplateUtil.getTemplatePath(), function, "rules", fileName);
            return builder.toString();
        }
    }

    private String cleanLine(String line) {
        return line.replaceAll("\\s//.*", "");
    }
}
