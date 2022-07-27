package com.jhl.admin.util.subscribe.parser;

import com.jhl.admin.constant.ClientConstant;
import com.jhl.admin.util.Utils;
import com.jhl.admin.util.subscribe.TemplateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ClashRulesParser implements IRulesParser {
    private final String[] excludeTypes = {"USER-AGENT", "AND", "URL-REGEX"};

    @Override
    public String getTarget() {
        return ClientConstant.Clash;
    }

    @Override
    public String content(String fileName, String group) {
        Function<String, String> function = line -> {
            if (StringUtils.isBlank(line)) {
                return "";
            }
            if (line.startsWith("#")) {
                return "  " + line + System.lineSeparator();
            }
            line = cleanLine(line);
            if (StringUtils.startsWithAny(line, excludeTypes)) {
                return "  #" + line + System.lineSeparator();
            }
            String target = this.getTarget();
            if (ClientConstant.Clash.equals(target)) {
                return "  - " + line + "," + group + System.lineSeparator();
            } else {
                return "  - " + line + System.lineSeparator();
            }
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
