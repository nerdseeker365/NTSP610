package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.BankLoanService;

public class MethodReplacerTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankLoanService service=null;
		//create IOC container
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get Service class object
		service=ctx.getBean("bank",BankLoanService.class);
		//invoke methods
		System.out.println(service.calcIntrAmt(100000, 12));
		//close container
		((AbstractApplicationContext) ctx).close();
	}
}
