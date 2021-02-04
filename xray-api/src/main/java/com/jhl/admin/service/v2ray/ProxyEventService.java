package com.jhl.admin.service.v2ray;

import com.alibaba.fastjson.JSON;
import com.jhl.admin.model.Account;
import com.jhl.admin.repository.AccountRepository;
import com.jhl.admin.repository.UserRepository;
import com.jhl.admin.service.ServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static com.jhl.admin.service.v2ray.ProxyEvent.*;

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
	V2rayAccountService v2rayAccountService;
	@Autowired
	XrayService xrayService;

	private LinkedBlockingQueue<ProxyEvent> queue = new LinkedBlockingQueue<>();

	public void reloadProxyAccounts() {
		List<Account> allAccount = accountRepository.findAll(Example.of(Account.builder().status(1).build()));
		allAccount.forEach(account -> {
			addProxyEvent(buildV2RayProxyEvent(account, ProxyEvent.RM_EVENT));
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
						case ADD_EVENT:
						case UPDATE_EVENT:
							event.createEvent();
//                            throw new UnsupportedOperationException("已经不在支持");
							break;
						case RM_EVENT:
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

	public List<V2RayProxyEvent> buildV2RayProxyEvent(Account account, String opName) {
		Assert.notNull(account, "account is null");
		List<V2RayProxyEvent> v2RayProxyEvents = new ArrayList<>();
		v2RayProxyEvents.add(new V2RayProxyEvent(opName, account, xrayService, serverService, userRepository));
		return v2RayProxyEvents;
	}

}
