package com.jhl.admin.util.subscribe.parser;

import com.jhl.admin.constant.ClientConstant;
import org.springframework.stereotype.Component;

@Component
public class Clash2RulesParser extends ClashRulesParser {
    @Override
    public String getTarget() {
        return ClientConstant.ClashPremium.getValue();
    }

    @Override
    public String content(String fileName, String group) {
        String payload = "payload:";
        return payload + System.lineSeparator() + super.content(fileName, group);
    }
}
