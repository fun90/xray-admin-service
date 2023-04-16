package com.jhl.admin.util.subscribe.generator;

import com.jhl.admin.constant.ClientConstant;
import com.jhl.admin.model.Account;
import com.jhl.admin.model.Server;
import com.jhl.admin.util.subscribe.RulesParserFactory;
import com.jhl.admin.util.subscribe.parser.IRulesParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShadowrocketConfigGenerator implements IConfigGenerator {
    @Autowired
    private RulesParserFactory rulesParserFactory;

    @Override
    public String getTarget() {
        return ClientConstant.Shadowrocket.getValue();
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
        IRulesParser rulesParser = rulesParserFactory.get(this.getTarget());
        return rulesParser.content(ruleUrl, group);
    }
}
