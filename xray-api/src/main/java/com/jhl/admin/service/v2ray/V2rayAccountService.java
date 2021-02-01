package com.jhl.admin.service.v2ray;

import com.alibaba.fastjson.JSON;
import com.jhl.admin.constant.CustomConstant;
import com.jhl.admin.constant.ProxyConstant;
import com.jhl.admin.entity.V2rayAccount;
import com.jhl.admin.model.Account;
import com.jhl.admin.model.Server;
import com.jhl.admin.repository.AccountRepository;
import com.ljh.common.utils.V2RayPathEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Service
public class V2rayAccountService {
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
		String encode = Base64.getEncoder().encodeToString(JSON.toJSONString(v2rayAccount).getBytes(StandardCharsets.UTF_8));
		System.out.println(JSON.toJSONString(v2rayAccount));
		System.out.println(encode);
	}

	public String buildB64V2rayAccount(List<Server> servers, Account account, Integer type) {
		StringBuilder sb = new StringBuilder();
		if (type == 0) {
			if (account.getLevel() == 3) {
				customConstant.getMyExternalServers().forEach(server -> sb.append(server).append("\n"));
			}
			customConstant.getExternalServers().forEach(server -> sb.append(server).append("\n"));
			for (V2rayAccount v2rayAccount : buildV2rayAccount(servers, account)) {
				String encode = Base64.getEncoder().encodeToString(JSON.toJSONString(v2rayAccount).getBytes(StandardCharsets.UTF_8));
				sb.append("vmess://").append(encode).append("\n");
			}
		} else {
			//vui.fun90.com = vmess, vui.fun90.com, 443, chacha20-ietf-poly1305, "52ef5369-5a90-464a-aff7-2bde1fc02640", group=provider, over-tls=true, tls-host=vui.fun90.com,
			// certificate=0, obfs=ws, obfs-path="/ws/wangjiehan:009a1ba91a10cb02b4703dd0185037fc/",
			// obfs-header="Host: vui.fun90.com[Rr][Nn]User-Agent: Mozilla/5.0 (iPhone; CPU iPhone OS 11_2_6 like Mac OS X) AppleWebKit/604.5.6 (KHTML, like Gecko) Mobile/15D100"
			for (V2rayAccount v2rayAccount : buildV2rayAccount(servers, account)) {
				StringBuilder stb = new StringBuilder(v2rayAccount.getPs()).append("=").append("vmess,").append(v2rayAccount.getAdd()).append(",")
//                        .append(v2rayAccount.getPort()).append(",").append("chacha20-ietf-poly1305,\"").append(v2rayAccount.getId()).append("\",")
						.append(v2rayAccount.getPort()).append(",").append("none,\"").append(v2rayAccount.getId()).append("\",")
						.append("group=").append(v2rayAccount.getAdd()).append(",");
				boolean tls = "tls".equals(v2rayAccount.getTls());
				stb.append("over-tls=").append(tls).append(",").append(tls ? "tls-host=" + v2rayAccount.getAdd() + "," : "")
						.append("certificate=0, obfs=ws, obfs-path=\"").append(v2rayAccount.getPath()).append("\",")
						.append("obfs-header=\"Host: ").append(v2rayAccount.getAdd()).append("[Rr][Nn]User-Agent: Mozilla/5.0 (iPhone; CPU iPhone OS 11_2_6 like Mac OS X) AppleWebKit/604.5.6 (KHTML, like Gecko) Mobile/15D100\"");
				String encode = Base64.getEncoder().encodeToString(stb.toString().getBytes(StandardCharsets.UTF_8));
				sb.append("vmess://").append(encode).append("\n");
			}
		}
		return sb.toString();
	}

	public String buildB64V2rayAccount(List<Server> servers, Account account) {
		StringBuilder sb = new StringBuilder();
		for (V2rayAccount v2rayAccount : buildV2rayAccount(servers, account)) {
			String encode = Base64.getEncoder().encodeToString(JSON.toJSONString(v2rayAccount).getBytes(StandardCharsets.UTF_8));
			sb.append("vmess://").append(encode).append("\n");
		}

		return sb.toString();
	}

	public List<V2rayAccount> buildV2rayAccount(List<Server> servers, Account account) {

		String uuid = account.getUuid();
		if (account.getUuid() == null) {
			//兼容旧版
			V2rayAccount oldV2ray = JSON.parseObject(account.getContent(), V2rayAccount.class);
			uuid = oldV2ray == null ? UUID.randomUUID().toString() : oldV2ray.getId();
			account.setUuid(uuid);
			accountRepository.save(account);
		}
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
