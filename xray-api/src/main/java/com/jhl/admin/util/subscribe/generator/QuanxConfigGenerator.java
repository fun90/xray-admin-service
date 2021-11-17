package com.jhl.admin.util.subscribe.generator;

import com.jhl.admin.model.Account;
import com.jhl.admin.model.Server;
import com.jhl.admin.util.Utils;
import org.apache.commons.codec.binary.Base64;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class QuanxConfigGenerator implements IConfigGenerator {

    @Override
    public String getProxies(List<Server> servers, Account account) {
        return "";
    }

    @Override
    public String getServerNames(List<Server> servers, String append) {
        return servers.stream().map(Server::getServerName).collect(Collectors.joining(","));
    }

    @Override
    public String getRules(String ruleUrl, String rootUrl, String group) {
        String base64Url = Base64.encodeBase64String(ruleUrl.getBytes(StandardCharsets.UTF_8));
        String base64Group = Base64.encodeBase64String(group.getBytes(StandardCharsets.UTF_8));
        UriComponents components = ServletUriComponentsBuilder.fromUriString(rootUrl)
                .path("/subscribe/rules/quanx")
                .pathSegment(Utils.urlEncode(Base64.encodeBase64String(Utils.urlEncode(base64Url).getBytes(StandardCharsets.UTF_8))))
                .pathSegment(Utils.urlEncode(Base64.encodeBase64String(base64Group.getBytes(StandardCharsets.UTF_8))))
                .build();
        return components.toUriString() + ", tag=" + group;
    }
}
