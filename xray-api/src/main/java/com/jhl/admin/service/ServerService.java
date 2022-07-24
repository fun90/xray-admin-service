package com.jhl.admin.service;

import com.jhl.admin.constant.enumObject.StatusEnum;
import com.jhl.admin.model.Account;
import com.jhl.admin.model.Server;
import com.jhl.admin.repository.ServerRepository;
import com.jhl.admin.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServerService {

	@Autowired
	ServerRepository serverRepository;

	public List<Server> distinctServers(Account account) {
		List<Server> allServers = this.listByLevel(account.getLevel());
		Map<String, Server> serverMap = new HashMap<>();
		allServers.forEach(o -> {
			serverMap.putIfAbsent(o.getV2rayIp() + ":" + o.getV2rayManagerPort() + ":" + o.getInboundTag(), o);
		});
		return new ArrayList<>(serverMap.values());
	}


	public List<Server> listByLevel(Short level) {
		Validator.isNotNull(level);
		List<Server> all = serverRepository.findByLevelLessThanEqualAndStatusOrderByLevelDesc(level, StatusEnum.SUCCESS.code());
		Collections.shuffle(all);
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
				.clientDomain(server.getClientDomain()).clientPort(server.getClientPort())
				.inboundTag(server.getInboundTag()).protocol(server.getProtocol())
				.build())
		);
	}

	public Server findByIdAndStatus(Integer id, Integer status) {
		if (status == null) status = StatusEnum.SUCCESS.code();
		Server server = serverRepository.findById(id).orElse(null);
		if (server != null && !server.getStatus().equals(status)) {
			server = null;
		}
		return server;

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
