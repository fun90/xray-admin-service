package com.fun90.admin.service.v2ray;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.fun90.admin.constant.CustomConstant;
import com.fun90.admin.constant.ProxyConstant;
import com.fun90.admin.entity.V2rayAccount;
import com.fun90.admin.model.Account;
import com.fun90.admin.model.Server;
import com.fun90.admin.repository.AccountRepository;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class XrayAccountService {
	private final Logger logger = LoggerFactory.getLogger(XrayAccountService.class);
	@Autowired
    ProxyConstant proxyConstant;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	private CustomConstant customConstant;

	public static void main(String[] args) {
		V2rayAccount v2rayAccount = new V2rayAccount();
		v2rayAccount.setPs("TCP");
		v2rayAccount.setAdd("world.fun90.com");
		v2rayAccount.setPort("8080");
		v2rayAccount.setId("799371e4-3f2b-4eb1-825e-caa70a681986");
		v2rayAccount.setAid("64");
		v2rayAccount.setNet("tcp");
		v2rayAccount.setType("none");
		v2rayAccount.setHost("world.fun90.com");
//                v2rayAccount.setPath();
		v2rayAccount.setTls("tls");
		String encode = Base64.encodeBase64String(JSON.toJSONString(v2rayAccount).getBytes(StandardCharsets.UTF_8));
		System.out.println(JSON.toJSONString(v2rayAccount));
		System.out.println(encode);
	}

	private V2rayAccount buildV2rayAccount(Server s, Account account) {
		V2rayAccount v2rayAccount = new V2rayAccount();
		String uuid = account.getUuid();
		v2rayAccount.setId(uuid);
		v2rayAccount.setAdd(s.getClientDomain());
		v2rayAccount.setPort(String.valueOf(s.getClientPort()));
		JSONObject json = JSON.parseObject(s.getProtocolField());
		v2rayAccount.setTls(StringUtils.defaultString(json.getString("tls")));
		v2rayAccount.setHost("");
		v2rayAccount.setPs(s.getServerName());
		v2rayAccount.setAid(account.getMaxConnection().toString());
		return v2rayAccount;
	}

	public List<V2rayAccount> buildV2rayAccount(List<Server> servers, Account account) {
		List<V2rayAccount> result = new ArrayList<>(servers.size());
		for (Server s : servers) {
			V2rayAccount v2rayAccount = this.buildV2rayAccount(s, account);
			result.add(v2rayAccount);
		}
		return result;
	}
}
