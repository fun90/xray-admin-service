package com.fun90.admin.controller;

import com.fun90.admin.VO.OnlineVO;
import com.fun90.admin.cache.OnlineCache;
import com.fun90.admin.model.Account;
import com.fun90.admin.model.User;
import com.fun90.admin.repository.AccountRepository;
import com.fun90.admin.service.UserService;
import com.fun90.admin.util.IPUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

@Slf4j
@RestController
@RequestMapping("/hysteria")
public class HysteriaAuthController {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private OnlineCache onlineCache;
	@Autowired
	private Executor executor;
	@Autowired
	private UserService userService;

	@PostMapping("/auth")
	public Map<String, Object> auth(@RequestBody Map<String, String> map, HttpServletRequest request) {
		String auth = map.get("auth");
		Account exp = new Account();
		exp.setUuid(auth);
		exp.setStatus(1);
		Account account = accountRepository.findOne(Example.of(exp)).orElse(null);
		boolean authPass = account != null;
		Map<String, Object> result = new HashMap<>();
		result.put("id", auth);
		result.put("ok", authPass);

		String serverIp = IPUtil.getIp(request);
		log.info("Hysteria身份验证，参数：{}，服务器IP：{}，验证结果：{}", map, serverIp, authPass);
		if (authPass) {
			executor.execute(() -> {
				OnlineVO vo = new OnlineVO();
				vo.setDatetime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
				vo.setIp(map.get("addr"));
				User user = userService.get(account.getUserId());
				vo.setEmail(user.getEmail());
				onlineCache.add(vo);
			});
		}
		return result;
	}
}
