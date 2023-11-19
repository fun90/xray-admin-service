package com.fun90.admin.service;

import com.fun90.admin.constant.enumObject.StatusEnum;
import com.fun90.admin.model.Account;
import com.fun90.admin.model.Server;
import com.fun90.admin.repository.ServerRepository;
import com.fun90.admin.util.Validator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ServerService {

	@Autowired
	ServerRepository serverRepository;

	public List<Server> queryXrayServers(Account account) {
		return queryServers(account, Set.of("vmess", "trojan", "vless"));
	}

	public List<Server> queryHysteria2Servers() {
		return serverRepository.findByProtocolInAndStatus(Set.of("hysteria2"), StatusEnum.SUCCESS.code());
	}

	public List<Server> queryHysteria2Servers(Account account) {
		return queryServers(account, Set.of("hysteria2"));
	}

	public List<Server> queryServers(Account account, Set<String> protocols) {
		Validator.isNotNull(account);
		String serverIds = account.getServerId();
		List<Server> allServers;
		if (!"0".equals(serverIds) && StringUtils.isNoneBlank(serverIds)) {
			allServers = this.queryByServerIds(serverIds);
		} else {
			allServers = serverRepository.findByLevelLessThanEqualAndStatusOrderByLevelDesc(account.getLevel(), StatusEnum.SUCCESS.code());
		}
		allServers = allServers.stream().filter(o -> protocols.contains(o.getProtocol())).collect(Collectors.toList());
		Map<String, Server> serverMap = new HashMap<>();
		allServers.forEach(o -> {
			serverMap.putIfAbsent(o.getV2rayIp() + ":" + o.getV2rayManagerPort() + ":" + o.getInboundTag(), o);
		});
		return new ArrayList<>(serverMap.values());
	}

	public List<Server> queryByAccount(Account account) {
		Validator.isNotNull(account);
		String serverIds = account.getServerId();

		List<Server> all;
		if (!"0".equals(serverIds) && StringUtils.isNoneBlank(serverIds)) {
			all = this.queryByServerIds(serverIds);
		} else {
			all = serverRepository.findByLevelLessThanEqualAndStatusOrderByLevelDesc(account.getLevel(), StatusEnum.SUCCESS.code());
		}
		String toDate = "(" + new SimpleDateFormat("yyyy-MM-dd").format(account.getToDate()) + ")";
		for (Server server : all) {
			server.setServerName(server.getServerName() + toDate);
		}
		Collections.shuffle(all);
		return all;
	}

	public List<Server> queryByServerIds(String serverIds) {
		List<Server> all = new ArrayList<>();
		if (StringUtils.isNoneBlank(serverIds)) {
			all = serverRepository.findAllById(Arrays.stream(serverIds.split(",")).map(Integer::valueOf).collect(Collectors.toList()));
			all = all.stream().filter(o -> Objects.equals(o.getStatus(), StatusEnum.SUCCESS.code())).collect(Collectors.toList());
		}
		return all;
	}

	public List<Server> queryAllAvailable() {
		List<Server> all = serverRepository.findAll();
		all = all.stream().filter(o -> Objects.equals(o.getStatus(), StatusEnum.SUCCESS.code())).collect(Collectors.toList());
		return all;
	}

	/**
	 * 增加服务器前，对域名进行检测 唯一
	 *
	 * @param server
	 */
	public void save(Server server) {
		if (findSameServers(server).size() > 0) {
			throw new IllegalArgumentException("服务重复了");
		}
		serverRepository.save(server);

	}

	public List<Server> findSameServers(Server server) {
		return serverRepository.findAll(Example.of(Server.builder()
				.v2rayIp(server.getV2rayIp()).clientPort(server.getClientPort())
				.inboundTag(server.getInboundTag()).protocol(server.getProtocol())
				.build())
		);
	}

	public void update(Server server) {
		Server checkServer = findSameServers(server).stream().findFirst().orElse(null);
		if (checkServer == null || checkServer.getId().equals(server.getId())) {
			serverRepository.save(server);
		} else {
			throw new IllegalArgumentException("服务重复了");
		}
	}
}
