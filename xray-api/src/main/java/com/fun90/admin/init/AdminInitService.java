package com.fun90.admin.init;

import com.fun90.admin.cron.RulesCron;
import com.fun90.admin.model.Account;
import com.fun90.admin.model.ServerConfig;
import com.fun90.admin.model.User;
import com.fun90.admin.repository.ServerConfigRepository;
import com.fun90.admin.service.AccountService;
import com.fun90.admin.service.StatService;
import com.fun90.admin.service.UserService;
import com.fun90.admin.service.v2ray.ProxyEventService;
import com.fun90.admin.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;

@Slf4j
@Service
public class AdminInitService {
	@Autowired
	ServerConfigRepository serverConfigRepository;
	@Autowired
    UserService userService;
	@Autowired
    AccountService accountService;
	@Autowired
    StatService statService;
	@Autowired
    ProxyEventService proxyEventService;
	@Autowired
	RulesCron rulesCron;
	@Value("${admin.email}")
	String email;
	@Value("${admin.password}")
	String password;

	public static void main(String[] args) {
		System.out.println(Boolean.valueOf("true1"));
	}

	@PostConstruct
	public void init() {
		initServer();

		rulesCron.execute();

		proxyEventService.addProxyAccounts();
	}

	public void initServer() {
		ServerConfig initialedConfig = serverConfigRepository.findOne(Example.of(ServerConfig.builder().key("initialed").build())).orElse(null);

		if (initialedConfig != null && Boolean.parseBoolean(initialedConfig.getValue())) {
			return;
		}

		//todo 新增一个管理员账号
		User user = User.builder().email(email).password(DigestUtils.md5Hex(password)).nickName("admin").role("admin").status(1).build();
		userService.create(user);
		Account ac = Account.builder().userId(user.getId()).build();
		ac.setCycle(30);
		Date date = Utils.formatDate(new Date(), null);
		ac.setToDate(Utils.getDateBy(date, 365, Calendar.DAY_OF_YEAR));
		accountService.create(ac);
		statService.createOrGetStat(ac);
		initialedConfig = new ServerConfig();
		initialedConfig.setKey("initialed");
		initialedConfig.setValue("true");
		serverConfigRepository.save(initialedConfig);
	}
}
