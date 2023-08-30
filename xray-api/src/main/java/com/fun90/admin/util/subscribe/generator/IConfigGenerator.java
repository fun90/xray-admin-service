package com.fun90.admin.util.subscribe.generator;

import com.fun90.admin.model.Account;
import com.fun90.admin.model.Server;

import java.util.List;

public interface IConfigGenerator {
    String getTarget();

    String getProxies(List<Server> servers, Account account);

    String getServerNames(List<Server> servers, String append);

    String getRules(String ruleUrl, String rootUrl, String group);
}
