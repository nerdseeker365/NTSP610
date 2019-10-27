package com.nt.config;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.nt.advice.PerformenceMonitoringAdvice;
import com.nt.pointcut.CommonsAddMulDynaPointcut;
import com.nt.target.AirthmeticOperationsService;

@Configuration
@ComponentScan(basePackages= {"com.nt.target","com.nt.advice","com.nt.pointcut"})
public class AppConfig {
	@Autowired
	private AirthmeticOperationsService target;
	@Autowired
	private PerformenceMonitoringAdvice advice;
	@Autowired
	private CommonsAddMulDynaPointcut ptc;
	
	@Bean(name="pmAdvisor")
	public  Advisor  createAdvisor() {
		DefaultPointcutAdvisor advisor=null;
		advisor=new DefaultPointcutAdvisor(ptc,advice);
		return advisor;
	}
	
	@Bean(name="pfb")
	public  ProxyFactoryBean   createPFB() {
		ProxyFactoryBean pfb=null;
		pfb=new ProxyFactoryBean();
		pfb.setTarget(target);
		pfb.addAdvisor(createAdvisor());
		return pfb;
	}
	
	
	

	
}
