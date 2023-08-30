package com.fun90.admin.controller;

import com.fun90.admin.VO.AccountVO;
import com.fun90.admin.VO.ServerVO;
import com.fun90.admin.VO.UserVO;
import com.fun90.admin.cache.UserCache;
import com.fun90.admin.constant.KVConstant;
import com.fun90.admin.interceptor.PreAuth;
import com.fun90.admin.model.Account;
import com.fun90.admin.model.Server;
import com.fun90.admin.repository.ServerRepository;
import com.fun90.admin.service.AccountService;
import com.fun90.admin.service.ServerService;
import com.fun90.admin.util.Result;
import com.fun90.admin.util.Validator;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
public class ServerController {

	@Autowired
	ServerRepository serverRepository;
	@Autowired
	ServerService serverService;
	@Autowired
	UserCache userCache;
	@Autowired
	AccountService accountService;

	@PreAuth("vip")
	@ResponseBody
	@GetMapping("/server/{id}")
	public Result get(@PathVariable Integer id) {
		Validator.isNotNull(id);
		Server server = serverRepository.findById(id).orElse(null);
		return Result.builder().code(Result.CODE_SUCCESS).obj(server == null ? null : server.toVO(ServerVO.class)).build();
	}

	@PreAuth("admin")
	@ResponseBody
	@GetMapping("/server")
	public Result findByPage(Integer page, Integer pageSize, @CookieValue(KVConstant.COOKIE_NAME) String auth) {
		Validator.isNotNull(page);
		Validator.isNotNull(pageSize);
		Page<Server> all = serverRepository.findAll(Example.of(Server.builder().build()), PageRequest.of(page - 1, pageSize));
		;
		ArrayList<Object> VOList = Lists.newArrayListWithCapacity(all.getContent().size());
		all.getContent().forEach(server -> {
			VOList.add(server.toVO(ServerVO.class));
		});
		return Result.buildPageObject(all.getTotalElements(), VOList);
	}

	@PreAuth("admin")
	@ResponseBody
	@GetMapping("/server/findAllAvailable")
	public Result findAll() {
		List<Server> all = serverService.queryAllAvailable();
		ArrayList<Object> VOList = Lists.newArrayListWithCapacity(all.size());
		all.forEach(server -> {
			VOList.add(server.toVO(ServerVO.class));
		});
		return Result.buildSuccess(VOList, null);
	}

	@PreAuth("vip")
	@ResponseBody
	@GetMapping("/server/findServersForAccount")
	public Result findServersForAccount(@CookieValue(KVConstant.COOKIE_NAME) String auth) {

		UserVO user = userCache.getCache(auth);
		List<AccountVO> accounts = accountService.getAccounts(user.getId());
		if (accounts.size() != 1) return Result.builder().code(500).message("用户存在多个账号/或者账号为空").build();
		AccountVO account = accounts.get(0);
		Account data = Account.builder()
				.accountNo(account.getAccountNo())
				.level(account.getLevel())
				.build();
		if (CollectionUtils.isNotEmpty(account.getServerIds())) {
			data.setServerId(account.getServerIds().stream().map(Object::toString).collect(Collectors.joining(",")));
		}
		List<Server> servers = serverService.queryByAccount(data);
		ArrayList<Object> VOList = Lists.newArrayListWithCapacity(servers.size());
		servers.forEach(server -> {
			VOList.add(server.toVO(ServerVO.class));
		});
		return Result.buildSuccess(VOList, null);
	}

	@PreAuth("admin")
	@ResponseBody
	@DeleteMapping("/server/{id}")
	public Result del(@PathVariable Integer id) {
		Validator.isNotNull(id);
		serverRepository.deleteById(id);
		return Result.builder().code(Result.CODE_SUCCESS).build();
	}

	/**
	 * 新增
	 *
	 * @return
	 */
	@PreAuth("admin")
	@ResponseBody
	@PostMapping("/server")
	public Result insert(@RequestBody Server server) {
		Validator.isNotNull(server);
		serverService.save(server);
		return Result.doSuccess();
	}

	/**
	 * 修改
	 */
	@PreAuth("admin")
	@ResponseBody
	@PutMapping("/server")
	public Result update(@RequestBody Server server) {
		Validator.isNotNull(server);


		serverService.update(server);

		//todo 修改服务器后的逻辑 1.更新账号2.推送到中间件
		return Result.builder().code(Result.CODE_SUCCESS).build();
	}
}
