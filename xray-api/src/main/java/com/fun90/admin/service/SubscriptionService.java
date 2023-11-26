package com.fun90.admin.service;

import com.fun90.admin.constant.ProxyConstant;
import com.fun90.admin.model.Account;
import com.fun90.admin.model.Subscription;
import com.fun90.admin.repository.AccountRepository;
import com.fun90.admin.repository.SubscriptionRepository;
import com.fun90.admin.util.Utils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionService {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
    SubscriptionRepository subscriptionRepository;
	@Autowired
	private ProxyConstant proxyConstant;

	public Subscription findByCode(String code) {
		if (code == null) {
			throw new IllegalArgumentException("code can't be null");
		}
		Optional<Subscription> subscriptionOptional = subscriptionRepository.findOne(Example.of(Subscription.builder().code(code).build()));
		if (subscriptionOptional.isEmpty()) {
			throw new IllegalArgumentException("the code doesn't exist");
		}
		return subscriptionOptional.get();
	}

	public Subscription findByAccountId(Integer accountId) {
		if (accountId == null) throw new IllegalArgumentException(" can't be null");
		Optional<Subscription> subscriptionOptional =
				subscriptionRepository.findOne(Example.of(Subscription.builder().accountId(accountId).build()));

		return subscriptionOptional.orElse(null);
	}

	public void addSubscription(Subscription subscription) {
		if (subscription == null || subscription.getAccountId() == null) throw new RuntimeException(" can't be null");

		if (subscription.getCode() == null) subscription.setCode(generatorCode());

		subscriptionRepository.save(subscription);

	}

	public String generatorCode() {
		return DigestUtils.md5Hex(System.currentTimeMillis() + proxyConstant.getAuthPassword());
	}
}
