package com.jhl.admin.util.subscribe.generator;

import com.jhl.admin.constant.ClientConstant;
import com.jhl.admin.model.Account;
import com.jhl.admin.model.Server;
import com.jhl.admin.util.Utils;
import com.jhl.admin.util.subscribe.TemplateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ShadowrocketConfigGenerator implements IConfigGenerator {
    @Autowired
    private ClientConstant clientConstant;

    @Override
    public String getTarget() {
        return "shadowrocket";
    }

    @Override
    public String getProxies(List<Server> servers, Account account) {
       return "";
    }

    @Override
    public String getServerNames(List<Server> servers, String append) {
        return "";
    }

    @Override
    public String getRules(String ruleUrl, String rootUrl, String group) {
        if (StringUtils.startsWithAny(ruleUrl, "https://", "http://")) {
            return Utils.call(ruleUrl, rulesParser(group));
        } else {
            return Utils.writeString(TemplateUtil.getTemplatePath(), rulesParser(group), "rules", ruleUrl);
        }
    }

    public Function<String, String> rulesParser(String group) {
        return line -> {
            if (StringUtils.isBlank(line)) {
                return System.lineSeparator();
            }
            if (line.startsWith("#")) {
                return line + System.lineSeparator();
            }
            line = cleanLine(line);
            String[] arr = line.split(",");
            if (arr.length < 2) {
                return line + System.lineSeparator();
            }
            List<String> excludeTypes = clientConstant.getExcludeRuleTypes().get(this.getTarget());
            if (excludeTypes.contains(arr[0])) {
                return "#" + line + System.lineSeparator();
            }
            return line + "," + group + System.lineSeparator();
        };
    }

    public String cleanLine(String line) {
        // 替换掉行尾掉注释，如：" // Google"
        return line.replaceAll("\\s//.*", "");
    }
}
