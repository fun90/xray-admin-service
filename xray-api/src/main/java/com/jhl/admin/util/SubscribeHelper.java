package com.jhl.admin.util;

import com.jhl.admin.model.Server;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class SubscribeHelper {
    private String rootUrl;
    private String target;
    private String configUrl;
    private String proxiesUrl;

    public SubscribeHelper(String target, String rootUrl, String subscriptionUrl) {
        this.target = target;
        this.rootUrl = rootUrl;
        UriComponents configUri = ServletUriComponentsBuilder.fromUriString(subscriptionUrl)
                .replaceQueryParam("target", target)
                .replaceQueryParam("type", 1)
                .build();
        // 配置订阅地址
        this.configUrl = rootUrl + configUri.toUriString();
        // 代理节点订阅地址
        UriComponents proxiesUri = ServletUriComponentsBuilder.fromUriString(subscriptionUrl)
                .replaceQueryParam("target", target)
                .replaceQueryParam("type", 0)
                .build();
        this.proxiesUrl = rootUrl + proxiesUri.toUriString();
    }

    public String serverNames(List<Server> servers) {
        return serverNames(servers, "");
    }

    public String serverNames(List<Server> servers, String append) {
        if (StringUtils.equalsAny(target, "surge", "quanx")) {
            return servers.stream().map(Server::getServerName).collect(Collectors.joining(",")) + append;
        }
        return "";
    }

    public String parseRule(String ruleUrl) {
        return parseRule(ruleUrl, "");
    }

    public String parseRule(String ruleUrl, String group) {
        if (StringUtils.equalsAny(target, "surge", "loon")) {
            if (StringUtils.startsWithAny(ruleUrl, "https://", "http://")) {
                return ruleUrl;
            } else {
                return rootUrl + "/subscribe/rules/" + ruleUrl + "?target=" + target;
            }
        } else if ("quanx".equals(target)) {
            String base64Url = Base64.encodeBase64String(ruleUrl.getBytes(StandardCharsets.UTF_8));
            String base64Group = Base64.encodeBase64String(group.getBytes(StandardCharsets.UTF_8));
            if (StringUtils.startsWithAny(ruleUrl, "https://", "http://")) {
                return rootUrl + "/subscribe/rules/" + Utils.urlEncode(base64Url) + "?target=" + target + "&group=" + Utils.urlEncode(base64Group) + ", tag=" + group;
            } else {
                return rootUrl + "/subscribe/rules/" + Utils.urlEncode(base64Url) + "?target=" + target + "&group=" + Utils.urlEncode(base64Group) + ", tag=" + group;
            }
        }
        return "";
    }

    public String configUrl() {
        return configUrl;
    }

    public String proxiesUrl() {
        return proxiesUrl;
    }
}
