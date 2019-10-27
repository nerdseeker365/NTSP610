package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages="com.nt.controller")
public class WebMVCAppConfig {

	
	@Bean
	public  ViewResolver  createIRVR() {
		InternalResourceViewResolver resolver=null;
		resolver=new InternalResourceViewResolver("/WEB-INF/pages/",".jsp");
		return resolver;
	}
}
