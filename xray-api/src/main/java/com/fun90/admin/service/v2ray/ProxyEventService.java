package com.fun90.admin.service.v2ray;

import com.alibaba.fastjson2.JSON;
import com.fun90.admin.model.Account;
import com.fun90.admin.repository.AccountRepository;
import com.fun90.admin.repository.UserRepository;
import com.fun90.admin.service.ServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class ProxyEventService {
	@Autowired
	AccountRepository accountRepository;

	@Autowired
	ServerService serverService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	XrayAccountService xrayAccountService;
	@Autowired
	XrayService xrayService;

	private LinkedBlockingQueue<ProxyEvent> queue = new LinkedBlockingQueue<>();

	public void reloadProxyAccounts() {
		List<Account> allAccount = accountRepository.findByStatusAndToDateAfter(1, new Date());
		allAccount.forEach(account -> {
			addProxyEvent(buildV2RayProxyEvent(account, ProxyEvent.RM_EVENT));
			addProxyEvent(buildV2RayProxyEvent(account, ProxyEvent.ADD_EVENT));
		});
	}

	public void addProxyAccounts() {
		List<Account> allAccount = accountRepository.findByStatusAndToDateAfter(1, new Date());
		allAccount.forEach(account -> {
			addProxyEvent(buildV2RayProxyEvent(account, ProxyEvent.ADD_EVENT));
		});
	}

	public void addProxyEvent(List<? extends ProxyEvent> proxyEvents) {
		for (ProxyEvent proxyEvent : proxyEvents) {
			try {
				boolean succeeded = queue.offer(proxyEvent, 10, TimeUnit.SECONDS);
				if (!succeeded) log.warn("can not add ProxyEvent: {} to queue", JSON.toJSONString(proxyEvent));
			} catch (InterruptedException e) {
				log.error("addProxyEvent error", e);
				Thread.currentThread().interrupt();
			}
		}

	}

	@PostConstruct
	public void start() {
		new Thread(() -> {

			while (true) {
				try {
					//block
					ProxyEvent event = queue.take();
					log.info("start send event:{},{}", event.getEvent(), JSON.toJSONString(event));
					switch (event.getEvent()) {
						case ProxyEvent.ADD_EVENT:
						case ProxyEvent.UPDATE_EVENT:
							event.createEvent();
//                            throw new UnsupportedOperationException("已经不在支持");
							break;
						case ProxyEvent.RM_EVENT:
							event.rmEvent();
							break;
						default:
							log.error("unSupport Event ........");
							return;
					}
				} catch (InterruptedException e) {
					log.error("event InterruptedException :{}", e.getLocalizedMessage(), e);
					Thread.currentThread().interrupt();

					break;

				} catch (Exception e) {
					log.error("event 队列 抛出异常:{}", e.getLocalizedMessage(), e);
				}
			}

		}).start();

	}

    /*@PreDestroy
    public void destroy() throws InterruptedException {
        int timer = 0;
        while (true) {
            if (queue.size() > 0 && timer < 10) {
                Thread.sleep(200);
                timer++;
            } else break;
        }

    }*/

	public List<XrayProxyEvent> buildV2RayProxyEvent(Account account, String opName) {
		Assert.notNull(account, "account is null");
		List<XrayProxyEvent> xrayProxyEvents = new ArrayList<>();
		xrayProxyEvents.add(new XrayProxyEvent(opName, account, xrayService, serverService, userRepository));
		return xrayProxyEvents;
	}

}
