package com.fun90.admin.util.subscribe.parser;

import com.fun90.admin.constant.ClientConstant;
import org.springframework.stereotype.Component;

@Component
public class Clash2RulesParser extends ClashRulesParser {
    @Override
    public String getTarget() {
        return ClientConstant.ClashForWindows2.getTarget();
    }

    @Override
    public String content(String fileName, String group) {
        String payload = "payload:";
        return payload + System.lineSeparator() + super.content(fileName, group);
    }
}
