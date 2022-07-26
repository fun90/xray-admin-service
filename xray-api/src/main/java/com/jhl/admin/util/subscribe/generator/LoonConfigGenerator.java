package com.jhl.admin.util.subscribe.generator;

import com.jhl.admin.constant.ClientConstant;
import com.jhl.admin.model.Account;
import com.jhl.admin.model.Server;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.util.List;

@Component
public class LoonConfigGenerator implements IConfigGenerator {

    @Override
    public String getTarget() {
        return ClientConstant.Loon;
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
            return ruleUrl;
        } else {
            UriComponents components = ServletUriComponentsBuilder.fromUriString(rootUrl).path("/subscribe/rules/loon").pathSegment(ruleUrl).build();
            return components.toUriString();
        }
    }
}
