package com.jhl.admin.cron;

import com.jhl.admin.constant.EmailConstant;
import com.jhl.admin.constant.KVConstant;
import com.jhl.admin.constant.enumObject.EmailEventEnum;
import com.jhl.admin.constant.enumObject.WebsiteConfigEnum;
import com.jhl.admin.model.*;
import com.jhl.admin.repository.AccountRepository;
import com.jhl.admin.repository.StatRepository;
import com.jhl.admin.service.*;
import com.jhl.admin.service.v2ray.ProxyEvent;
import com.jhl.admin.service.v2ray.ProxyEventService;
import com.jhl.admin.service.v2ray.XrayProxyEvent;
import com.jhl.admin.service.v2ray.XrayService;
import com.jhl.admin.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class AppCron {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	AccountService accountService;
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
	@Autowired
	private ServerConfigService serverConfigService;
	SimpleDateFormat sdf = new SimpleDateFormat(KVConstant.YYYYMMddHHmmss);
	private long M = 1024 * 1024L;
	private long G = 1024 * M;
	private BigDecimal mDecimal = BigDecimal.valueOf(M);

	@Scheduled(cron = "0 0/10 * * * ?")
	public void stat() {
		ServerConfig serverConfig = serverConfigService.getServerConfig(WebsiteConfigEnum.TASK_ENABLE.getKey());
		if (!"true".equals(serverConfig.getValue())) {
			log.info("======= 统计流量任务已被禁用，请查看系统配置：{} =======", WebsiteConfigEnum.TASK_ENABLE.getKey());
			return;
		}
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
			// 同一IP与管理端口为同一服务器
			servers = servers.stream().filter(Utils.distinctByKey((o) -> o.getV2rayIp() + o.getV2rayManagerPort())).collect(Collectors.toList());
			User user = userService.get(account.getUserId());
			long addition = 0;
			for (Server server : servers) {
				long downTraffic = xrayService.getDownlinkTraffic(server.getV2rayIp(), server.getV2rayManagerPort(), user.getEmail());
				addition += downTraffic;
				long upTraffic = xrayService.getUplinkTraffic(server.getV2rayIp(), server.getV2rayManagerPort(), user.getEmail());
				addition += upTraffic;
				if (downTraffic != 0 || upTraffic != 0) {
					String d = BigDecimal.valueOf(downTraffic).divide(mDecimal, 3, RoundingMode.HALF_UP).toPlainString();
					String u = BigDecimal.valueOf(upTraffic).divide(mDecimal, 3, RoundingMode.HALF_UP).toPlainString();
					if (!d.equals("0.000") || !u.equals("0.000")) {
						log.info("{}({}), {}, up：{}M, down: {}M", user.getEmail(), user.getRemark(), server.getV2rayIp(), u, d);
					}
				}
			}
			if (addition != 0) {
				stat.setFlow(stat.getFlow() + addition);
				statRepository.save(stat);
			}
			//流量超过,增加RM事件
			if ((account.getBandwidth() * G) < stat.getFlow()) {
				log.warn("账号流量已经超强限制：accountId = {}, email = {}", account.getId(), user.getEmail());
				List<XrayProxyEvent> xrayProxyEvents = getProxyEvents(account);
				proxyEventService.addProxyEvent(xrayProxyEvents);
			}
		});
	}

	private List<XrayProxyEvent> getProxyEvents(Account account) {
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
		ServerConfig serverConfig = serverConfigService.getServerConfig(WebsiteConfigEnum.TASK_ENABLE.getKey());
		if (!"true".equals(serverConfig.getValue())) {
			log.info("======= 账号过期检查任务已被禁用，请查看系统配置：{} =======", WebsiteConfigEnum.TASK_ENABLE.getKey());
			return;
		}

		log.info("账号过期提醒任务。。开始，{}", new Date());
		Date now = new Date();
		List<Account> accountList = accountRepository.findAll(Example.of(Account.builder().status(1).build()));
		accountList.forEach(account -> {

			Date toDate = account.getToDate();
			if (!toDate.after(now)) {
				if (account.getStatus() == 1) {
					// 过期禁用账号
					account.setStatus(0);
					accountService.updateAccount(account);
				}
				return;
			}

			if (toDate.getTime() - now.getTime() <= KVConstant.MS_OF_DAY * 3L) {

				Integer userId = account.getUserId();
				if (userId == null) return;
				User user = userService.get(userId);
				if (user == null) return;

				String email = user.getEmail();
				if (email.endsWith("@anonymous.com")) {
					return;
				}

				EmailEventHistory latestHistory = emailService.findLatestHistory(email, EmailEventEnum.CHECK_OVERDUE_TO_DATE.name());
				//检测 事件的 unlock date 如果未到unlock date 跳过
				if (latestHistory != null && latestHistory.getUnlockDate().after(now)) return;

				emailService.sendEmail(email, "多鱼账号即将到期",
						String.format(emailConstant.getOverdueDate(), sdf.format(toDate)),
						EmailEventHistory.builder().event(EmailEventEnum.CHECK_OVERDUE_TO_DATE.name())
								.email(email)
								.unlockDate(toDate)
								.build());
			}
		});

	}


}
