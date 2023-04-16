package com.jhl.admin.util.subscribe.generator;

import com.jhl.admin.constant.ClientConstant;
import com.jhl.admin.model.Account;
import com.jhl.admin.model.Server;
import com.jhl.admin.util.subscribe.RulesParserFactory;
import com.jhl.admin.util.subscribe.parser.IRulesParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ClashConfigGenerator implements IConfigGenerator {
    @Autowired
    private RulesParserFactory rulesParserFactory;

    @Override
    public String getTarget() {
        return ClientConstant.Clash.getValue();
    }

    @Override
    public String getProxies(List<Server> servers, Account account) {
        String trojanTemplate = "   - {name: %s, server: %s, port: %s, type: trojan, password: %s, sni: %s, skip-cert-verify: true, udp: false}";
        String vmessTemplate = "   - {name: %s, server: %s, port: %s, type: vmess, uuid: %s, alterId: %s, cipher: auto, tls: true, skip-cert-verify: true, network: ws, ws-opts: {path: %s, headers: {Host: %s}}, udp: false}";
//        String socketTemplate = "   - {name: %s, server: %s, port: %s, type: socks5, skip-cert-verify: true, udp: false}";
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
        IRulesParser rulesParser = rulesParserFactory.get(this.getTarget());
        return rulesParser.content(ruleUrl, group);
    }
}
