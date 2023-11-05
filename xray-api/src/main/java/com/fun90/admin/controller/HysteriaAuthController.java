package com.fun90.admin.controller;

import com.fun90.admin.model.Account;
import com.fun90.admin.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/hysteria")
public class HysteriaAuthController {
	@Autowired
	private AccountRepository accountRepository;

	@PostMapping("/auth")
	public Map<String, Object> auth(@RequestBody Map<String, String> map) {
		log.info("Hysteria身份验证，参数：{}", map);

		String auth = map.get("auth");
		Account exp = new Account();
		exp.setUuid(auth);
		exp.setStatus(1);
		Account account = accountRepository.findOne(Example.of(exp)).orElse(null);
		Map<String, Object> result = new HashMap<>();
		result.put("id", auth);
		result.put("ok", account != null);
		return result;
	}
}
