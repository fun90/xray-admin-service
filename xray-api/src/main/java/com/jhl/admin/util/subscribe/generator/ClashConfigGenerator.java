package com.jhl.admin.util.subscribe.generator;

import com.jhl.admin.model.Account;
import com.jhl.admin.model.Server;
import com.jhl.admin.util.Utils;
import com.jhl.admin.util.subscribe.TemplateUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ClashConfigGenerator implements IConfigGenerator {

    @Override
    public String getProxies(List<Server> servers, Account account) {
        String trojanTemplate = "   - {name: %s, server: %s, port: %s, type: trojan, password: %s, sni: %s, skip-cert-verify: true, udp: true}";
        String vmessTemplate = "   - {name: %s, server: %s, port: %s, type: vmess, uuid: %s, alterId: %s, cipher: auto, tls: true, skip-cert-verify: true, network: ws, ws-path: %s, ws-headers: {Host: %s}, udp: true}";
        String socketTemplate = "   - {name: %s, server: %s, port: %s, type: socks5, skip-cert-verify: true, udp: true}";
        return servers.stream().map(o -> {
            if ("trojan".equals(o.getProtocol())) {
                return String.format(trojanTemplate, o.getServerName(), o.getClientDomain(), o.getClientPort(), account.getUuid(), o.getClientDomain());
            } else if ("vmess".equals(o.getProtocol())) {
                return String.format(vmessTemplate, o.getServerName(), o.getClientDomain(), o.getClientPort(), account.getUuid(), account.getMaxConnection(), o.getWsPath(), o.getClientDomain());
            } else {
                return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String getServerNames(List<Server> servers, String append) {
        return servers.stream().map(o -> "      - " + o.getServerName()).collect(Collectors.joining(System.lineSeparator()));
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
                return "  " + line + System.lineSeparator();
            }
            line = cleanLine(line);
            String[] arr = line.split(",");
            if (arr.length < 2) {
                return "  " + line + System.lineSeparator();
            }
            if (StringUtils.equalsAny(arr[0], "USER-AGENT", "AND", "URL-REGEX")) {
                return "  #" + line + System.lineSeparator();
            }
            String[] newArr = Arrays.copyOf(arr, arr.length + 1);
            String noResolve = "no-resolve";
            if (newArr[newArr.length - 2].equals(noResolve)) {
                newArr[newArr.length - 2] = group;
                newArr[newArr.length - 1] = noResolve;
            } else {
                newArr[newArr.length - 1] = group;
            }
            return "  - " + String.join(",", newArr) + System.lineSeparator();
        };
    }

    public String cleanLine(String line) {
        return line.replaceAll("\\s//.*", "");
    }
}
