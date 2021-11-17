package com.jhl.admin.util.subscribe.generator;

import com.jhl.admin.model.Account;
import com.jhl.admin.model.Server;

import java.util.List;

public interface IConfigGenerator {
    String getProxies(List<Server> servers, Account account);

    String getServerNames(List<Server> servers, String append);

    String getRules(String ruleUrl, String rootUrl, String group);
}
