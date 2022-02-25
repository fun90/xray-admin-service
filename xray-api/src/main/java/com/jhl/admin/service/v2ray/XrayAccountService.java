package com.jhl.admin.service.v2ray;

import com.alibaba.fastjson.JSON;
import com.jhl.admin.constant.CustomConstant;
import com.jhl.admin.constant.ProxyConstant;
import com.jhl.admin.entity.V2rayAccount;
import com.jhl.admin.model.Account;
import com.jhl.admin.model.Server;
import com.jhl.admin.repository.AccountRepository;
import com.ljh.common.utils.V2RayPathEncoder;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class XrayAccountService {
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
		List<Server> trojanList = servers.stream().filter(o -> "trojan".equalsIgnoreCase(o.getProtocol())).collect(Collectors.toList());
		for (Server server : trojanList) {
			try {
				sb.append("trojan://").append(account.getUuid()).append("@")
						.append(server.getClientDomain()).append(":").append(server.getClientPort())
						.append("?allowInsecure=1&xtls=1")
						.append("#").append(URLEncoder.encode(server.getServerName(), "UTF-8"))
						.append("\n");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		List<Server> vmessList = servers.stream().filter(o -> o.getProtocol() == null || "vmess".equalsIgnoreCase(o.getProtocol())).collect(Collectors.toList());
		for (V2rayAccount v2rayAccount : buildV2rayAccount(vmessList, account)) {
			String encode = Base64.encodeBase64String(JSON.toJSONString(v2rayAccount).getBytes(StandardCharsets.UTF_8));
			sb.append("vmess://").append(encode).append("\n");
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
			V2rayAccount v2rayAccount = new V2rayAccount();
			v2rayAccount.setId(uuid);
			v2rayAccount.setAdd(s.getClientDomain());
			v2rayAccount.setPort(String.valueOf(s.getClientPort()));
			String token = V2RayPathEncoder.encoder(account.getAccountNo(), s.getClientDomain(), proxyConstant.getAuthPassword());
			v2rayAccount.setPath(String.format(s.getWsPath(), account.getAccountNo() + ":" + token));
			v2rayAccount.setTls(s.getSupportTLS() ? "tls" : "");
			v2rayAccount.setHost("");
			v2rayAccount.setPs(s.getServerName());
			v2rayAccount.setAid(account.getMaxConnection().toString());
			result.add(v2rayAccount);
		}
		return result;
	}
}
