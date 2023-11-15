package com.fun90.admin.service;

import com.fun90.admin.VO.AccountVO;
import com.fun90.admin.VO.StatVO;
import com.fun90.admin.VO.UserVO;
import com.fun90.admin.constant.ClientConstant;
import com.fun90.admin.constant.KVConstant;
import com.fun90.admin.constant.ProxyConstant;
import com.fun90.admin.model.Account;
import com.fun90.admin.model.Stat;
import com.fun90.admin.model.Subscription;
import com.fun90.admin.model.User;
import com.fun90.admin.repository.AccountRepository;
import com.fun90.admin.repository.ServerRepository;
import com.fun90.admin.repository.StatRepository;
import com.fun90.admin.service.v2ray.ProxyEvent;
import com.fun90.admin.service.v2ray.ProxyEventService;
import com.fun90.admin.service.v2ray.XrayAccountService;
import com.fun90.admin.util.Utils;
import com.fun90.admin.util.Validator;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	ServerRepository serverRepository;

	@Autowired
	StatRepository statRepository;
	@Autowired
    ProxyEventService proxyEventService;
	@Autowired
	StatService statService;
	@Autowired
    XrayAccountService xrayAccountService;
	@Autowired
	UserService userService;
	@Autowired
	SubscriptionService subscriptionService;
	@Autowired
	ServerService serverService;

	@Autowired
	private ProxyConstant proxyConstant;

	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
	}

	/**
	 * 新增一个账号
	 *
	 * @param account
	 * @return
	 */
	public Account create(Account account) {
		Validator.isNotNull(account.getUserId());
		Date date = new Date();
		if (account.getBandwidth() == null) {
			account.setBandwidth(200);
		}

		account.setAccountNo(Utils.getCharAndNum(12));
		//1024kb/S
		if (account.getSpeed() == null) account.setSpeed(10240L);

		Date fromDate = Utils.formatDate(date, null);
		if (account.getFromDate() == null) account.setFromDate(fromDate);
		if (account.getCycle() == null) {
			account.setCycle(KVConstant.MONTH);
		}
		if (account.getMaxConnection() == null) account.setMaxConnection(0);
		if (account.getToDate() == null)
			account.setToDate(Utils.getDateBy(fromDate, KVConstant.DAY, Calendar.DAY_OF_YEAR));
		account.setStatus(1);
		if (account.getLevel() == null) account.setLevel((short) 0);

		account.setUuid(UUID.randomUUID().toString());

		account = accountRepository.save(account);

		proxyEventService.addProxyEvent(proxyEventService.buildV2RayProxyEvent(account, ProxyEvent.ADD_EVENT));
		return account;
	}

	/**
	 * 更新账号的信息，不涉及服务器相关/content相关
	 */
	public void updateAccount(Account account) {
		Validator.isNotNull(account.getId());
		// 保留旧数据
		Account oldAccount = accountRepository.findById(account.getId())
				.map(o -> {
					Account target = new Account();
					BeanUtils.copyProperties(o, target);
					return target;
				})
				.orElse(null);
		if (StringUtils.isBlank(account.getServerId())) {
			// 清空serverId，更新为0
			account.setServerId("0");
		}
		accountRepository.save(account);
		Account newAccount = accountRepository.findById(account.getId()).orElse(null);

		//判断是否需要生成新的stat
		if (newAccount != null) {
			statService.createOrGetStat(newAccount);
		}
		//删除事件
		proxyEventService.addProxyEvent(proxyEventService.buildV2RayProxyEvent(oldAccount, ProxyEvent.RM_EVENT));
		if (newAccount != null && newAccount.getStatus() == 1) {
			proxyEventService.addProxyEvent(proxyEventService.buildV2RayProxyEvent(newAccount, ProxyEvent.UPDATE_EVENT));
		}
	}

	@Deprecated
	@Transactional
	public void updateAccountServer(Account account) {
		Integer id = account.getId();
		Account dbAccount = accountRepository.findById(id).orElse(null);
		if (dbAccount == null || dbAccount.getStatus() == 0 || !dbAccount.getToDate().after(new Date())) {
			throw new IllegalStateException("账号不可用");
		}
		accountRepository.save(account);


       /*
        String email = userService.get(dbAccount.getUserId()).getEmail();
       //删除旧服务器账号
        if (oldServerId != null) {
            Server oldServer = serverRepository.getOne(oldServerId);
              Account toSendAccount =new Account();
            BeanUtils.copyProperties(dbAccount,toSendAccount);
            V2RayProxyEvent rmEvent = new V2RayProxyEvent(restTemplate, oldServer,toSendAccount , email, ProxyEvent.RM_EVENT);
            proxyEventService.addProxyEvent(rmEvent);
        }


        //同时也确保删除新服务器账号，好重新获取
       Account newAccount = accountRepository.findById(id).orElse(null);
        V2RayProxyEvent rmEvent = new V2RayProxyEvent(restTemplate, newServer,newAccount , email, ProxyEvent.RM_EVENT);
        proxyEventService.addProxyEvent(rmEvent);*/

	}

	/**
	 * 获取一个用户下面的账号.并且填充
	 *
	 * @param userId
	 * @return
	 */
	public List<AccountVO> getAccounts(Integer userId) {

		Date date = new Date();

		List<Account> accounts = accountRepository.findAll(Example.of(Account.builder().userId(userId).build()));
		List<AccountVO> accountVOList = Lists.newArrayListWithCapacity(accounts.size());
		accounts.forEach(account -> {
			AccountVO accountVO = account.toVO(AccountVO.class);
			fillAccount(date, accountVO);
			accountVOList.add(accountVO);

		});
		return accountVOList;
	}

	public Account getAccount(Integer userId) {


		List<Account> accounts = accountRepository.findAll(Example.of(Account.builder().userId(userId).build()));
		if (accounts.size() > 1) throw new IllegalArgumentException("用户存在多个账号，请修复");
		return accounts.isEmpty() ? null : accounts.get(0);
	}

	public void fillAccount(Date date, AccountVO account) {
		Integer accountId = account.getId();
		Stat stat = statRepository.findByAccountIdAndFromDateBeforeAndToDateAfter(accountId, date, date);

		Integer userId = account.getUserId();
		User user = userService.getUserButRemovePW(userId);
		if (user != null) account.setUserVO(user.toVO(UserVO.class));
		if (stat != null) account.setStatVO(stat.toVO(StatVO.class));
	}

	/**
	 * https://xxx/subscribe/{code}?target=?&timestamp=?&token=?
	 * <p>
	 * code code
	 * target 订阅类型
	 * token  md5(code+timestamp+api.auth)
	 *
	 * @param accountId
	 */

	public String generatorSubscriptionUrl(Integer accountId, String target, Integer type) {
		Subscription subscription = subscriptionService.findByAccountId(accountId);
		if (subscription == null) {
			subscription = Subscription.builder().accountId(accountId).code(subscriptionService.generatorCode()).build();
		} else {
			subscription.setCode(subscriptionService.generatorCode());

		}
		subscriptionService.addSubscription(subscription);

		Account account = accountRepository.findById(accountId).orElse(null);
		Assert.notNull(account, "account is null");
		long timeStamp = System.currentTimeMillis();

		String token = DigestUtils.md5Hex(subscription.getCode() + timeStamp + proxyConstant.getAuthPassword());
		type = type == null ? 0 : type;
		target = StringUtils.defaultString(target, ClientConstant.DEFAULT.getValue());
		String url = String.format(proxyConstant.getSubscriptionTemplate(), subscription.getCode(), target, type, timeStamp, token);
		account.setSubscriptionUrl(url);
		accountRepository.save(account);
		return url;
	}
/*
    public List<Account> listAllAccount(List<ClientInfo> users) {
        ArrayList<Account> allAccounts = Lists.newArrayList();
        users.forEach(user -> {
            List<Account> accounts = getAccounts(user.getId());
            allAccounts.addAll(allAccounts);
        });
        return allAccounts;
    }
*/

	public Account findByAccountNo(String accountNo) {
		Assert.notNull(accountNo, "accountNo must not be null");
		Account account = accountRepository.findOne(Example.of(Account.builder()
				.accountNo(accountNo).status(KVConstant.V_TRUE).build())).orElse(null);
		return account;

	}


}
