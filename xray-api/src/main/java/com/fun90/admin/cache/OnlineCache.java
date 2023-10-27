package com.fun90.admin.cache;

import com.fun90.admin.VO.OnlineVO;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Slf4j
@Component
public class OnlineCache {

	private Cache<String, String> cacheManager = CacheBuilder.newBuilder().
			maximumSize(2000).expireAfterWrite(3, TimeUnit.MINUTES).build();


	public void add(OnlineVO vo) {
		if (StringUtils.isNotBlank(vo.getIp())) {
			cacheManager.put(vo.getIp().split(":")[0], vo.getEmail());
		}
	}

	public List<String> getIpList(String email) {
		return cacheManager.asMap().entrySet().stream()
				.filter(entry -> email.equals(entry.getValue()))
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
	}
}
