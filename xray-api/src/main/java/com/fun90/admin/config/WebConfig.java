package com.fun90.admin.config;

import com.alibaba.fastjson2.support.config.FastJsonConfig;
import com.alibaba.fastjson2.support.spring.http.converter.FastJsonHttpMessageConverter;
import com.fun90.admin.constant.ProxyConstant;
import com.fun90.admin.interceptor.AuthInterceptor;
import com.google.common.collect.Lists;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	AuthInterceptor authInterceptor;
	@Autowired
    ProxyConstant proxyConstant;

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//		configurer.defaultContentType(MediaType.APPLICATION_JSON_UTF8);
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		//定义一个convert转换消息的对象
		FastJsonHttpMessageConverter fastConverter=new FastJsonHttpMessageConverter();
		//添加fastjson的配置信息，比如是否要格式化返回的json数据；
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
//		fastJsonConfig.setWriterFeatures(
//				//是否输出值为null的字段,默认为false
//				JSONWriter.Feature.WriteMapNullValue,
//				//将Collection类型字段的字段空值输出为[]
//				JSONWriter.Feature.WriteNullListAsEmpty,
//				//将字符串类型字段的空值输出为空字符串
//				JSONWriter.Feature.WriteNullStringAsEmpty
//		);
		fastJsonConfig.setDateFormat("millis");
		//在convert中添加配置信息
		fastConverter.setFastJsonConfig(fastJsonConfig);
		//设置支持的媒体类型
		fastConverter.setSupportedMediaTypes(Lists.newArrayList(MediaType.APPLICATION_JSON));
		//设置默认字符集
		fastConverter.setDefaultCharset(StandardCharsets.UTF_8);
		//将convert添加到converters
		converters.add(0, fastConverter);

		StringHttpMessageConverter defaultConverter = new StringHttpMessageConverter();
		defaultConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		defaultConverter.setDefaultCharset(StandardCharsets.UTF_8);
		converters.add(0, defaultConverter);
	}

//	@Bean
//	public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
//		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
//		fastJsonHttpMessageConverter.setSupportedMediaTypes(Lists.newArrayList(MediaType.APPLICATION_JSON));
//		return fastJsonHttpMessageConverter;
//	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		fastJsonHttpMessageConverter.setSupportedMediaTypes(Lists.newArrayList(MediaType.APPLICATION_JSON));
		restTemplate.getMessageConverters().add(fastJsonHttpMessageConverter);
		restTemplate.getInterceptors().add((request, body, execution) -> {
			HttpHeaders headers = request.getHeaders();
			headers.add("Authorization", DigestUtils.md5Hex(proxyConstant.getAuthPassword()));
			headers.setContentType(MediaType.APPLICATION_JSON);
			return execution.execute(request, body);
		});
		return restTemplate;
	}

	/**
	 * 拦截器
	 *
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor).addPathPatterns("/**");
	}

	@Bean
	public Executor executor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(1);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(5);
		executor.setThreadNamePrefix("aync-executor-");
		executor.initialize();
		return executor;
	}

}
