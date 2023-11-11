package com.fun90.admin.cron;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.fun90.admin.constant.EmailConstant;
import com.fun90.admin.constant.KVConstant;
import com.fun90.admin.constant.enumObject.EmailEventEnum;
import com.fun90.admin.constant.enumObject.WebsiteConfigEnum;
import com.fun90.admin.model.*;
import com.fun90.admin.repository.AccountRepository;
import com.fun90.admin.repository.StatRepository;
import com.fun90.admin.service.*;
import com.fun90.admin.service.v2ray.ProxyEvent;
import com.fun90.admin.service.v2ray.ProxyEventService;
import com.fun90.admin.service.v2ray.XrayProxyEvent;
import com.fun90.admin.service.v2ray.XrayService;
import com.fun90.admin.util.Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;
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

	@Scheduled(cron = "0 1/8 * * * ?")
	public void stat() {
		ServerConfig serverConfig = serverConfigService.getServerConfig(WebsiteConfigEnum.TASK_ENABLE.getKey());
		if (!"true".equals(serverConfig.getValue())) {
			log.info("======= 统计流量任务已被禁用，请查看系统配置：{} =======", WebsiteConfigEnum.TASK_ENABLE.getKey());
			return;
		}
		Date today = new Date();
		log.info("======= 统计流量任务开始 =======");
		List<Account> allAccounts = accountRepository.findAll(Example.of(Account.builder().status(1).build()));
		allAccounts.forEach(account -> {
			List<Server> servers = serverService.queryXrayServers(account);
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
						log.info("Xray: {}({}), {}, up：{}M, down: {}M", user.getEmail(), user.getRemark(), server.getV2rayIp(), u, d);
					}
				}
			}

			this.saveStat(account, today, addition);
		});


		hysteria2Stat(allAccounts, today);
	}

	private void hysteria2Stat(List<Account> allAccounts, Date today) {
		Map<String, JSONObject> trafficData = this.queryHysteria2Traffic();

		Map<String, Account> accountMap = allAccounts.stream().collect(Collectors.toMap(Account::getUuid, v -> v));
		Map<Account, Long> trafficMap = new HashMap<>();
		trafficData.forEach((serverInfo, traffic) -> {
			for (Map.Entry<String, Object> entry : traffic.entrySet()) {
				String uuid = entry.getKey();
				Account account = accountMap.get(uuid);
				if (account == null) {
					continue;
				}

				JSONObject accountTraffic = (JSONObject) entry.getValue();
				long addition = 0;
				long downTraffic = accountTraffic.getLongValue("rx");
				addition += downTraffic;
				long upTraffic = accountTraffic.getLongValue("tx");
				addition += upTraffic;
				if (downTraffic != 0 || upTraffic != 0) {
					String d = BigDecimal.valueOf(downTraffic).divide(mDecimal, 3, RoundingMode.HALF_UP).toPlainString();
					String u = BigDecimal.valueOf(upTraffic).divide(mDecimal, 3, RoundingMode.HALF_UP).toPlainString();
					if (!d.equals("0.000") || !u.equals("0.000")) {
						User user = userService.get(account.getUserId());
						log.info("Hysteria2流量统计 {}({}), {}, up：{}M, down: {}M", user.getEmail(), user.getRemark(), serverInfo, u, d);
					}
				}
				trafficMap.put(account, addition);
			}
		});

		trafficMap.forEach((account, addition) -> {
			this.saveStat(account, today, addition);
		});
	}

	private void saveStat(Account account, Date today, long addition) {
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
		if (addition != 0) {
			stat.setFlow(stat.getFlow() + addition);
			statRepository.save(stat);
		}
		//流量超过,增加RM事件
		if ((account.getBandwidth() * G) < stat.getFlow()) {
			log.warn("账号流量已经超强限制：accountId = {}", account.getId());
			List<XrayProxyEvent> xrayProxyEvents = getProxyEvents(account);
			proxyEventService.addProxyEvent(xrayProxyEvents);
		}
	}

	private Map<String, JSONObject> queryHysteria2Traffic() {
		List<Server> servers = serverService.queryHysteria2Servers();
		Map<String, JSONObject> statMap = new HashMap<>();
		for (Server server : servers) {
			JSONObject statJson = null;
			try {
				JSONObject serverJson = JSON.parseObject(server.getProtocolField());
				String response = Utils.call("http://" + server.getV2rayIp() + ":" + server.getV2rayManagerPort() + "/traffic?clear=1", serverJson.getString("auth"), null);
				if (StringUtils.isNotBlank(response)) {
					statJson = JSON.parseObject(response);
				}
			} catch (Exception e) {
				log.info("Hysteria2流量统计异常: {}", e.getMessage(), e);
				continue;
			}
			if (statJson != null) {
				statMap.put(server.getV2rayIp() + "_" + server.getServerName(), statJson);
			}
		}
		return statMap;
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
