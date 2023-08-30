package com.fun90.admin.util.subscribe.generator;

import com.fun90.admin.constant.ClientConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

@Component
public class Clash2ConfigGenerator extends ClashConfigGenerator {
    @Override
    public String getTarget() {
        return ClientConstant.ClashPremium.getValue();
    }

    @Override
    public String getRules(String ruleUrl, String rootUrl, String group) {
        if (StringUtils.startsWithAny(ruleUrl, "https://", "http://")) {
            return ruleUrl;
        } else {
            UriComponents components = ServletUriComponentsBuilder.fromUriString(rootUrl).path("/subscribe/rules/clash2").pathSegment(ruleUrl).build();
            return components.toUriString();
        }
    }
}
