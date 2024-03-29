package com.jhl.admin.service;

import com.jhl.admin.constant.ClientConstant;
import com.jhl.admin.model.Account;
import com.jhl.admin.model.Subscription;
import com.jhl.admin.repository.AccountRepository;
import com.jhl.admin.repository.SubscriptionRepository;
import com.jhl.admin.service.v2ray.XrayAccountService;
import com.jhl.admin.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionService {

	@Autowired
	AccountService accountService;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	SubscriptionRepository subscriptionRepository;
	@Autowired
	ServerService serverService;
	@Autowired
	XrayAccountService xrayAccountService;
	@Autowired
	ClientConstant clientConstant;

	/**
	 * 通过一个订阅code寻找账号
	 *
	 * @param code
	 * @return
	 */
	public Account findAccountByCode(String code) {
		if (code == null) throw new IllegalArgumentException("code can't be null");
		Optional<Subscription> subscriptionOptional =
				subscriptionRepository.findOne(Example.of(Subscription.builder().code(code).build()));
		if (!subscriptionOptional.isPresent()) throw new IllegalArgumentException("the code doesn't exist");

		Integer accountId = subscriptionOptional.get().getAccountId();


		return accountRepository.findById(accountId).orElse(null);
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

	/**
	 * @param code 可以为空
	 * @param id
	 */
	public void updateSubscription(String code, Integer id) {
		if (code == null) code = generatorCode();
		Subscription subscription = Subscription.builder().code(code).build();
		subscription.setId(id);
		subscriptionRepository.save(subscription);

	}


	public String generatorCode() {

		return Utils.getCharAndNum(10);
	}
}
