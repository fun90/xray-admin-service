package com.fun90.admin.controller;

import com.fun90.admin.VO.AccountVO;
import com.fun90.admin.VO.OnlineVO;
import com.fun90.admin.VO.UserVO;
import com.fun90.admin.cache.OnlineCache;
import com.fun90.admin.cache.UserCache;
import com.fun90.admin.constant.KVConstant;
import com.fun90.admin.constant.ProxyConstant;
import com.fun90.admin.constant.enumObject.StatusEnum;
import com.fun90.admin.constant.enumObject.WebsiteConfigEnum;
import com.fun90.admin.entity.V2rayAccount;
import com.fun90.admin.interceptor.PreAuth;
import com.fun90.admin.model.Account;
import com.fun90.admin.model.BaseEntity;
import com.fun90.admin.model.Server;
import com.fun90.admin.model.ServerConfig;
import com.fun90.admin.repository.AccountRepository;
import com.fun90.admin.repository.ServerRepository;
import com.fun90.admin.service.AccountService;
import com.fun90.admin.service.ServerConfigService;
import com.fun90.admin.service.ServerService;
import com.fun90.admin.service.SubscriptionService;
import com.fun90.admin.service.v2ray.ProxyEventService;
import com.fun90.admin.service.v2ray.XrayAccountService;
import com.fun90.admin.util.Result;
import com.fun90.admin.util.SubscriptionUrlUtil;
import com.fun90.admin.util.Validator;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class AccountController {
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	AccountService accountService;
	@Autowired
	UserCache userCache;
	@Autowired
	ServerService serverService;
	@Autowired
    XrayAccountService xrayAccountService;
	@Autowired
	ServerRepository serverRepository;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ServerConfigService serverConfigService;
	@Autowired
	SubscriptionService subscriptionService;
	@Autowired
	ProxyEventService proxyEventService;
	@Autowired
	private OnlineCache onlineCache;
	@Autowired
	private ProxyConstant proxyConstant;
	@Autowired
	private HttpServletRequest request;

	/**
	 * 创建一个account
	 *
	 * @return
	 */
	@PreAuth("admin")
	@ResponseBody
	@PostMapping("/account")
	public Result createAccount(@RequestBody AccountVO account) {
		if (account == null || account.getUserId() == null) throw new NullPointerException("不能为空");
		accountService.create(account.toModel(Account.class));
		return Result.doSuccess();
	}

	/**
	 * 更新一个账号
	 * 在账号的有效期内，但是用户的流量已经超过当前周期的流量。
	 * 用户再次续费，原则上不应该修改已有的计费周期，即用户还是上不了网。
	 * 但可以通过临时修改用户流量的大小，使用户可以继续上网。
	 * 等到系统自动生成下一个周期的记录时候，在修改回来。
	 *
	 * @param account
	 * @return
	 */
	@PreAuth("admin")
	@ResponseBody
	@PutMapping("/account")
	public Result updateAccount(@RequestBody AccountVO account) {
		if (account == null || account.getId() == null) throw new NullPointerException("不能为空");
		account.setSubscriptionUrl(null);
		Account data = account.toModel(Account.class);
		if (CollectionUtils.isNotEmpty(account.getServerIds())) {
			data.setServerId(account.getServerIds().stream().map(Object::toString).collect(Collectors.joining(",")));
		}
		accountService.updateAccount(data);
		return Result.doSuccess();
	}

	/**
	 * 根据服务器获取一个V2rayAccount
	 *
	 * @param serverId
	 * @return
	 */
	@PreAuth("vip")
	@ResponseBody
	@GetMapping("/account/v2rayAccount")
	public Result getV2rayAccount(Integer serverId, @CookieValue(KVConstant.COOKIE_NAME) String auth) {
		Validator.isNotNull(serverId);
		UserVO user = userCache.getCache(auth);
		Account account = accountService.getAccount(user.getId());
		if (account == null) return Result.builder().code(500).message("账号不存在").build();

		Server server = serverService.findByIdAndStatus(serverId, StatusEnum.SUCCESS.code());
		if (server == null) return Result.builder().code(500).message("服务器不存在").build();

		List<V2rayAccount> v2rayAccounts = xrayAccountService.buildV2rayAccount(Lists.newArrayList(server), account);
		return Result.buildSuccess(v2rayAccounts.get(0), null);
	}

	@PreAuth("admin")
	@ResponseBody
	@GetMapping("/account/reloadProxyAccount")
	public Result reloadProxyAccount() {
		proxyEventService.reloadProxyAccounts();
		return Result.doSuccess();
	}

	/**
	 * 跟换服务器账号
	 *
	 * @param account
	 * @return
	 */
	@PreAuth("vip")
	@ResponseBody
	@PutMapping("/account/server")
	public Result updateAccountServer(@RequestBody AccountVO account) {
		if (account == null || account.getId() == null) throw new NullPointerException("不能为空");
		accountService.updateAccountServer(account.toModel(Account.class));
		return Result.doSuccess();
	}

	/**
	 * 获取用户账号列表
	 *
	 * @return
	 */
	@PreAuth("vip")
	@ResponseBody
	@GetMapping("/account/{id}")
	public Result get(@CookieValue(KVConstant.COOKIE_NAME) String auth, @PathVariable Integer id) {
		if (auth == null || userCache.getCache(auth) == null) return Result.builder().code(500).message("认证失败").build();
		UserVO cacheUser = userCache.getCache(auth);
		Integer userId = cacheUser.getId();

		List<AccountVO> accounts = accountService.getAccounts(userId);
		AccountVO account = accounts.get(0);
		String subscriptionUrl = account.getSubscriptionUrl();
		if (StringUtils.isNoneBlank(subscriptionUrl)) {
			String urlPrefix = SubscriptionUrlUtil.getPrefix(request, serverConfigService);
			account.setSubscriptionUrl(urlPrefix + subscriptionUrl);
		}
		ServerConfig subconverter = serverConfigService.getServerConfig(WebsiteConfigEnum.SUB_CONVERTER_ADDRESS.getKey());
		account.setSubconverterUrl(subconverter.getValue());
		return Result.buildSuccess(account, null);
	}

	/**
	 * 获取所有列表
	 *
	 * @param page
	 * @param pageSize
	 * @return
	 */
	@PreAuth("admin")
	@ResponseBody
	@GetMapping("/account")
	public Result list(Integer page, Integer pageSize, String userEmail, String userRemark) {
		List<Account> accounts = Lists.newArrayList();
		long total = 0l;
		Date date = new Date();
		if (StringUtils.isNotBlank(userEmail)) {
			accounts = accountRepository.findByUserEmail("%" + userEmail + "%");
			total = accounts.size();
		} else if (StringUtils.isNotBlank(userRemark)) {
			accounts = accountRepository.findByUserRemark("%" + userRemark + "%");
			total = accounts.size();
		} else {
			Page<Account> accountsPage = accountRepository.findAll(Example.of(Account.builder().build()),
					PageRequest.of(page - 1, pageSize)
			);

			if (accountsPage.getSize() > 0) {
				accounts = accountsPage.getContent();
			}
			total = accountsPage.getTotalElements();
		}
		List<AccountVO> accountVOList = BaseEntity.toVOList(accounts, AccountVO.class);

		ServerConfig subConverter = serverConfigService.getServerConfig(WebsiteConfigEnum.SUB_CONVERTER_ADDRESS.getKey());
		String urlPrefix = SubscriptionUrlUtil.getPrefix(request, serverConfigService);

		Map<Integer, Account> accountMap = accounts.stream().collect(Collectors.toMap(BaseEntity::getId, o -> o));
		accountVOList.forEach(account -> {
			account.setSubconverterUrl(subConverter.getValue());
			String subscriptionUrl = account.getSubscriptionUrl();
			if (StringUtils.isNoneBlank(subscriptionUrl)) {
				account.setSubscriptionUrl(urlPrefix + subscriptionUrl);
			}
			accountService.fillAccount(date, account);
			Account data = accountMap.get(account.getId());
			if (!"0".equals(data.getServerId()) && StringUtils.isNotBlank(data.getServerId())) {
				account.setServerIds(Arrays.stream(data.getServerId().split(",")).map(Integer::valueOf).collect(Collectors.toList()));
			}

			account.setOnlineIps(onlineCache.getIpList(account.getUserVO().getEmail()));
		});
		return Result.buildPageObject(total, accountVOList);
	}

	/**
	 * 生成订阅url
	 *
	 * @param target 类型
	 * @return
	 */
	@PreAuth("vip")
	@ResponseBody
	@GetMapping("/account/generatorSubscriptionUrl")
	public Result generatorSubscriptionUrl(@CookieValue(KVConstant.COOKIE_NAME) String auth, String target, Integer type) {
		UserVO user = userCache.getCache(auth);
		Integer accountId = accountService.getAccount(user.getId()).getId();
		accountService.generatorSubscriptionUrl(accountId, target, type);
		return Result.doSuccess();
	}

	/**
	 * 生成订阅url
	 *
	 */
	@PreAuth("admin")
	@ResponseBody
	@GetMapping("/account/generatorSubscriptionUrl/{id}")
	public Result generatorSubscriptionUrlByAdmin(String target, Integer type, @PathVariable Integer id) {
		String urlPrefix = SubscriptionUrlUtil.getPrefix(request, serverConfigService);
		return Result.buildSuccess(urlPrefix + accountService.generatorSubscriptionUrl(id, target, type), null);
	}

	@PreAuth("vip")
	@ResponseBody
	@GetMapping("/account/getUUID")
	public Result getUUID() {
		return Result.buildSuccess(UUID.randomUUID().toString(), null);
	}

	@ResponseBody
	@PostMapping("/account/online/access/{machineName}")
	public Result access(@RequestBody OnlineVO onlineVO,  @PathVariable String machineName, @RequestHeader("Token") String token) {

		if (!proxyConstant.getAuthPasswordMD5().equals(token)) {
			return Result.builder().code(401).message("非法请求").build();
		}

		onlineVO.setMachineName(machineName);
		onlineCache.add(onlineVO);
		return Result.doSuccess();
	}


	@PreAuth("admin")
	@ResponseBody
	@PostMapping("/account/online/count")
	public Result count(String email) {
		return Result.buildSuccess(onlineCache.getIpList(email), null);
	}

    /*@Deprecated
    @PreAuth("vip")
    @ResponseBody
    @GetMapping("/account/connection/{accountId}")
    public Result getConnection(@PathVariable Integer accountId) {
        if (accountId == null) return Result.builder().code(500).message("不能为空").build();
        Account account = accountRepository.findById(accountId).orElse(null);
        int count = 0;
        if (account != null) {
            Integer serverId = account.getServerId();
            if (serverId == null) throw new RuntimeException("未设置服务器");
            Server server = serverRepository.findById(serverId).orElse(null);
            String proxyIps = server.getProxyIp();
            Integer proxyPort = server.getProxyPort();
            String accountNo = account.getAccountNo();


            for (String url : buildConnectionCountUrl(proxyIps, proxyPort)) {
                Result remoteConnection = getRemoteConnection(accountId, accountNo, url);

                if (remoteConnection.getCode().equals(200)) {
                    count += (Integer) remoteConnection.getObj();
                }

            }
        }
        return Result.buildSuccess(count, null);
    }*/


//    private List<String> buildConnectionCountUrl(String ips, Integer port) {
//
//        List<String> list = new ArrayList<>();
//        for (String ip : ips.split(",")) {
//            String to = ip + ":" + port;
//            list.add(String.format(PROXY_API_CONNECTION_COUNT_URL, to));
//        }
//        return list;
//    }
}
