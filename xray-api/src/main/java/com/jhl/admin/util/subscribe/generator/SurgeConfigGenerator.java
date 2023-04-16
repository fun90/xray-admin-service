package com.jhl.admin.util.subscribe.generator;

import com.jhl.admin.constant.ClientConstant;
import com.jhl.admin.model.Account;
import com.jhl.admin.model.Server;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class SurgeConfigGenerator implements IConfigGenerator {

    @Override
    public String getTarget() {
        return ClientConstant.Surge.getValue();
    }

    @Override
    public String getProxies(List<Server> servers, Account account) {
        String trojanTemplate = "%s = trojan, %s, %s, password=%s, sni=%s, skip-cert-verify=1, tfo=false, udp-relay=true";
        String vmessTemplate = "%s = vmess, %s, %s, username=%s, ws-path=%s, sni=%s, ws-headers=Host:%s, ws=true, tls=true, tls13=false, skip-cert-verify=1, tfo=false, udp-relay=true";
        String socketTemplate = "%s = socks5, %s, %s, skip-cert-verify=1, tfo=false, udp-relay=true";
        return servers.stream().map(o -> {
            if ("trojan".equals(o.getProtocol())) {
                return String.format(trojanTemplate, o.getServerName(), o.getClientDomain(), o.getClientPort(), account.getUuid(), o.getClientDomain());
            } else if ("vmess".equals(o.getProtocol())) {
                return String.format(vmessTemplate, o.getServerName(), o.getClientDomain(), o.getClientPort(), account.getUuid(), o.getWsPath(), o.getClientDomain(), o.getClientDomain());
            } else {
                return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String getServerNames(List<Server> servers, String append) {
        return servers.stream().map(Server::getServerName).collect(Collectors.joining(","));
    }

    @Override
    public String getRules(String ruleUrl, String rootUrl, String group) {
        if (StringUtils.startsWithAny(ruleUrl, "https://", "http://")) {
            return ruleUrl;
        } else {
            UriComponents components = ServletUriComponentsBuilder.fromUriString(rootUrl).path("/subscribe/rules/surge").pathSegment(ruleUrl).build();
            return components.toUriString();
        }
    }
}
