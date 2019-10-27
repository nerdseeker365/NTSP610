package com.nt.config;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.nt.target.LoanApprover;

@Configuration
@ComponentScan(basePackages= {"com.nt.target","com.nt.advice"})
public class AppConfig {
	@Autowired
	private LoanApprover approver;
	
	@Bean(name="pfb")
	public  ProxyFactoryBean  createPFB() {
		ProxyFactoryBean pfb=null;
		pfb=new ProxyFactoryBean();
		pfb.setTarget(approver);
		pfb.setInterceptorNames("auditAdvice");
		return pfb;
	}
	
	

}
