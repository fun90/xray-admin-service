package com.jhl.admin.cron;

import com.jhl.admin.constant.EmailConstant;
import com.jhl.admin.constant.KVConstant;
import com.jhl.admin.constant.enumObject.EmailEventEnum;
import com.jhl.admin.model.*;
import com.jhl.admin.repository.AccountRepository;
import com.jhl.admin.repository.StatRepository;
import com.jhl.admin.service.EmailService;
import com.jhl.admin.service.ServerService;
import com.jhl.admin.service.StatService;
import com.jhl.admin.service.UserService;
import com.jhl.admin.service.v2ray.ProxyEvent;
import com.jhl.admin.service.v2ray.ProxyEventService;
import com.jhl.admin.service.v2ray.V2RayProxyEvent;
import com.jhl.admin.service.v2ray.XrayService;
import com.ljh.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class AppCron {

	@Autowired
	AccountRepository accountRepository;


	@Autowired
	StatService statService;
	@Autowired
	StatRepository statRepository;
	@Autowired
	ProxyEventService proxyEventService;
	@Autowired
	EmailService emailService;
	@Autowired
	EmailConstant emailConstant;
	@Autowired
	UserService userService;
	@Autowired
	XrayService xrayService;
	@Autowired
	ServerService serverService;
	SimpleDateFormat sdf = new SimpleDateFormat(KVConstant.YYYYMMddHHmmss);
	private long G = 1024 * 1024 * 1024L;

	@Scheduled(cron = "0 0/1 * * * ?")
	public void stat() {
		Date today = new Date();
		log.info("======= 统计流量任务开始 =======");
		List<Account> accounts = accountRepository.findAll(Example.of(Account.builder().status(1).build()));
		accounts.forEach(account -> {
			Integer accountId = account.getId();
			Stat stat = statRepository.findByAccountIdAndFromDateBeforeAndToDateAfter(accountId, today, today);
			if (stat == null) {
				stat = statService.createOrGetStat(account);
				if (stat == null) {
					//原因：账号到期；增加rm
					proxyEventService.addProxyEvent(getProxyEvents(account));
					return;
				}
			}
			List<Server> servers = serverService.distinctServers(account);
			long used =  stat.getFlow();
			User user = userService.get(account.getUserId());
			for (Server server : servers) {
				used += xrayService.getDownLinkTraffic(server.getV2rayIp(), server.getV2rayManagerPort(), user.getEmail());
			}
			stat.setFlow(used);
			statRepository.save(stat);
			//流量超过,增加RM事件
			if ((account.getBandwidth() * G) < used) {
				log.warn("账号流量已经超强限制：accountId = {}, email = {}", account.getId(), user.getEmail());
				//不可用状态
				List<V2RayProxyEvent> v2RayProxyEvents = getProxyEvents(account);
				proxyEventService.addProxyEvent(v2RayProxyEvents);
				account.setStatus(0);
				accountRepository.save(account);
			}
		});
	}

	private List<V2RayProxyEvent> getProxyEvents(Account account) {
		return proxyEventService.buildV2RayProxyEvent(account, ProxyEvent.RM_EVENT);
	}

//	@Async
//	@Scheduled(cron = "0 0 1 * * ?")
//	public void createStatTimer() {
//		Date today = new Date();
//		log.info("构建下个stat任务。。开始，{}", today);
//		List<Account> accounts = accountRepository.findByToDateAfter(today);
//		if (accounts == null) return;
//		accounts.forEach(account -> statService.createOrGetStat(account));
//	}

	@Async
	@Scheduled(cron = "0 0 8 * * ?")
	//@Scheduled(fixedDelay = 60*1000)
	public void checkInvalidAccount() {
		log.info("账号过期提醒任务。。开始，{}", new Date());
		Date now = new Date();
		List<Account> accountList = accountRepository.findByToDateAfter(now);
		accountList.forEach(account -> {

			Date toDate = account.getToDate();
			Integer userId = account.getUserId();
			if (userId == null) return;
			if (!toDate.after(now)) return;
			if (toDate.getTime() - now.getTime() <= KVConstant.MS_OF_DAY * 3) {
				User user = userService.get(userId);
				if (user == null) return;


				String email = user.getEmail();

				EmailEventHistory latestHistory = emailService.findLatestHistory(email, EmailEventEnum.CHECK_OVERDUE_TO_DATE.name());
				//检测 事件的 unlock date 如果未到unlock date 跳过
				if (latestHistory != null && latestHistory.getUnlockDate().after(now)) return;

				emailService.sendEmail(email, "提醒：账号即将到期",
						String.format(emailConstant.getOverdueDate(), sdf.format(toDate)),
						EmailEventHistory.builder().event(EmailEventEnum.CHECK_OVERDUE_TO_DATE.name())
								.email(email)
								.unlockDate(toDate)
								.build());


			}

		});

	}
}
