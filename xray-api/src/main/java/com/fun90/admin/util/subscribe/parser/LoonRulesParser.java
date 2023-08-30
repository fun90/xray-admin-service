package com.fun90.admin.util.subscribe.parser;

import com.fun90.admin.constant.ClientConstant;
import org.springframework.stereotype.Component;

@Component
public class LoonRulesParser implements IRulesParser {

    @Override
    public String getTarget() {
        return ClientConstant.Loon.getValue();
    }

}
