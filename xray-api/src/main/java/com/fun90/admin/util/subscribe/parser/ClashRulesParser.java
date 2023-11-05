package com.fun90.admin.util.subscribe.parser;

import com.fun90.admin.constant.ClientConstant;
import com.fun90.admin.util.Utils;
import com.fun90.admin.util.subscribe.TemplateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class ClashRulesParser implements IRulesParser {
    private final String[] excludeTypes = {"USER-AGENT", "AND", "URL-REGEX"};

    @Override
    public String getTarget() {
        return ClientConstant.Clash.getValue();
    }

    @Override
    public String content(String fileName, String group) {
        StringBuilder builder = new StringBuilder();
        Consumer<String> function = line -> {
            if (StringUtils.isBlank(line)) {
                return;
            }
            if (line.startsWith("#")) {
                builder.append("  " + line + System.lineSeparator());
                return;
            }
            line = cleanLine(line);
            if (StringUtils.startsWithAny(line, excludeTypes)) {
//                return "  #" + line + System.lineSeparator();
                return;
            }
            line = StringUtils.replace(line, "DEST-PORT", "DST-PORT");
            if ("advertisinglitedomain.list".equals(fileName)) {
                line = "DOMAIN-SUFFIX," + line.substring(1);
            }
            String target = this.getTarget();
            if (ClientConstant.Clash.getValue().equals(target)) {
                line = StringUtils.removeEnd(line, ",no-resolve");
                builder.append("  - " + line + "," + group + System.lineSeparator());
            } else {
                builder.append("  - " + line + System.lineSeparator());
            }
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
