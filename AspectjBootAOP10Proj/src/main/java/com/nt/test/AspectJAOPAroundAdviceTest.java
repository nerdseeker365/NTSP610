package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.BankService;

@SpringBootApplication
@Import(AppConfig.class)
public class AspectJAOPAroundAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService  proxy=null;
		//create IOC container
		ctx=SpringApplication.run(AspectJAOPAroundAdviceTest.class,args);
		//get Bean
		proxy=ctx.getBean("bankService",BankService.class);
		System.out.println("Proxy obj class::  "+proxy.getClass());
		//inovke the method
		System.out.println("simple Intr Amt::"+proxy.calcSimpleIntrAmount(100000,2, 12));
		System.out.println("________________________");
		System.out.println("simple Intr Amt::"+proxy.calcSimpleIntrAmount(100000,2, 12));
		System.out.println(".....................");
		
		System.out.println("Compound Intr Amt::"+proxy.calcCompoundIntrAmount(100000,2, 12));
		System.out.println("__________________________");
		System.out.println("Compound Intr Amt::"+proxy.calcCompoundIntrAmount(100000,2, 12));
		
		System.out.println(".....................");
		//close container
		((AbstractApplicationContext) ctx).close();
		

	}

}
