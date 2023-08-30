package com.fun90.admin.service.v2ray;

import com.alibaba.fastjson2.JSON;
import com.fun90.admin.constant.CustomConstant;
import com.fun90.admin.constant.ProxyConstant;
import com.fun90.admin.entity.V2rayAccount;
import com.fun90.admin.model.Account;
import com.fun90.admin.model.Server;
import com.fun90.admin.repository.AccountRepository;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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

	public String buildXrayServerUrl(List<Server> servers, Account account) {
		StringBuilder sb = new StringBuilder();
		for (Server server : servers) {
			if ("trojan".equalsIgnoreCase(server.getProtocol())) {
				try {
					sb.append("trojan://").append(account.getUuid()).append("@")
							.append(server.getClientDomain()).append(":").append(server.getClientPort())
							.append("?allowInsecure=1&xtls=1")
							.append("#").append(URLEncoder.encode(server.getServerName(), "UTF-8"))
							.append("\n");
				} catch (UnsupportedEncodingException e) {
					logger.error(e.getMessage(), e);
				}
			} else if (server.getProtocol() == null || "vmess".equalsIgnoreCase(server.getProtocol())) {
				V2rayAccount v2rayAccount = this.buildV2rayAccount(server, account);
				String encode = Base64.encodeBase64String(JSON.toJSONString(v2rayAccount).getBytes(StandardCharsets.UTF_8));
				sb.append("vmess://").append(encode).append("\n");
			}
		}

		if (account.getLevel() == 3) {
			customConstant.getMyExternalServers().forEach(server -> sb.append(server).append("\n"));
		}

		customConstant.getExternalServers().forEach(server -> sb.append(server).append("\n"));
		return sb.toString();
	}

//	public String buildXrayServerUrl(List<Server> servers, Account account) {
//		StringBuilder sb = new StringBuilder();
//		for (V2rayAccount v2rayAccount : buildV2rayAccount(servers, account)) {
//			String encode = Base64.getEncoder().encodeToString(JSON.toJSONString(v2rayAccount).getBytes(StandardCharsets.UTF_8));
//			sb.append("vmess://").append(encode).append("\n");
//		}
//
//		return sb.toString();
//	}
	private V2rayAccount buildV2rayAccount(Server s, Account account) {
		V2rayAccount v2rayAccount = new V2rayAccount();
		String uuid = account.getUuid();
		v2rayAccount.setId(uuid);
		v2rayAccount.setAdd(s.getClientDomain());
		v2rayAccount.setPort(String.valueOf(s.getClientPort()));
		String token = V2RayPathEncoder.encoder(account.getAccountNo(), s.getClientDomain(), proxyConstant.getAuthPassword());
		v2rayAccount.setPath(String.format(s.getWsPath(), account.getAccountNo() + ":" + token));
		v2rayAccount.setTls(s.getSupportTLS() ? "tls" : "");
		v2rayAccount.setHost("");
		v2rayAccount.setPs(s.getServerName());
		v2rayAccount.setAid(account.getMaxConnection().toString());
		return v2rayAccount;
	}

	public List<V2rayAccount> buildV2rayAccount(List<Server> servers, Account account) {

		String uuid = account.getUuid();
//		if (account.getUuid() == null) {
//			//兼容旧版
//			V2rayAccount oldV2ray = JSON.parseObject(account.getContent(), V2rayAccount.class);
//			uuid = oldV2ray == null ? UUID.randomUUID().toString() : oldV2ray.getId();
//			account.setUuid(uuid);
//			accountRepository.save(account);
//		}
		List<V2rayAccount> result = new ArrayList<>(servers.size());
		for (Server s : servers) {
			V2rayAccount v2rayAccount = this.buildV2rayAccount(s, account);
			result.add(v2rayAccount);
		}
		return result;
	}
}
