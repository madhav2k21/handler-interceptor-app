package com.techleads.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.techleads.app.interceptor.LogIntercepter;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		WebMvcConfigurer.super.addInterceptors(registry);
		registry.addInterceptor(new LogIntercepter()).addPathPatterns("/messages");
	}

}
