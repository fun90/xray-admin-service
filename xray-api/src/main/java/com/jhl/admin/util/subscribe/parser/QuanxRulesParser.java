package com.jhl.admin.util.subscribe.parser;

import com.jhl.admin.constant.ClientConstant;
import com.jhl.admin.util.Utils;
import com.jhl.admin.util.subscribe.TemplateUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.function.Consumer;
import java.util.function.Function;

@Component
public class QuanxRulesParser implements IRulesParser {
    private final String[] excludeTypes = {"USER-AGENT", "AND", "URL-REGEX", "PROCESS-NAME", "DEST-PORT"};

    @Override
    public String getTarget() {
        return ClientConstant.QuantumultX.getValue();
    }

    @Override
    public String content(String fileName, String group) {

        try {
            group = URLDecoder.decode(group, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String finalGroup = group;

        StringBuilder builder = new StringBuilder();
        Consumer<String> function = line -> {
            if (StringUtils.isBlank(line)) {
                return;
            }
            line = cleanLine(line);
            if (StringUtils.startsWithAny(line, excludeTypes)) {
//                return "  #" + line + System.lineSeparator();
                return;
            }
            line = StringUtils.replace(line, "IP-CIDR6", "IP6-CIDR");
            line = StringUtils.replace(line, "DOMAIN", "HOST");
            line = StringUtils.removeEnd(line, ",no-resolve");
            builder.append(line).append(", ").append(finalGroup).append(System.lineSeparator());
            return;
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
