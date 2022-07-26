package com.jhl.admin.util.subscribe.parser;

import com.jhl.admin.constant.ClientConstant;
import org.springframework.stereotype.Component;

@Component
public class SurgeRulesParser implements IRulesParser {

    @Override
    public String getTarget() {
        return ClientConstant.Surge;
    }

}
