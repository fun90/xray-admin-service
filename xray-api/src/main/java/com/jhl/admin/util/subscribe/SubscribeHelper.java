package com.jhl.admin.util.subscribe;

import com.jhl.admin.model.Account;
import com.jhl.admin.model.Server;
import com.jhl.admin.util.subscribe.generator.IConfigGenerator;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.util.List;

public class SubscribeHelper {
    private final String rootUrl;
    private final String configUrl;
    private final String proxiesUrl;
    private final Account account;
    private final IConfigGenerator generator;

    public SubscribeHelper(String target, String rootUrl, String subscriptionUrl, Account account) {
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
        this.generator = ConfigGeneratorFactory.build(target);
        this.account = account;
    }

    public String proxies(List<Server> servers) {
        return generator.getProxies(servers, account);
    }

    public String serverNames(List<Server> servers) {
        return generator.getServerNames(servers, "");
    }

    public String serverNames(List<Server> servers, String append) {
        return generator.getServerNames(servers, append);
    }

    public String rules(String ruleUrl) {
        return generator.getRules(ruleUrl, rootUrl, "");
    }

    public String rules(String ruleUrl, String group) {
        return generator.getRules(ruleUrl, rootUrl, group);
    }

    public String configUrl() {
        return configUrl;
    }

    public String proxiesUrl() {
        return proxiesUrl;
    }
}
