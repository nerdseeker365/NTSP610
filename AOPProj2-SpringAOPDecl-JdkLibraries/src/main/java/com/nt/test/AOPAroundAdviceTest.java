package com.nt.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.target.BankService;
import com.nt.target.BankServiceImpl;

public class AOPAroundAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
	  //create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy obj
		proxy=ctx.getBean("pfb",BankService.class);
		System.out.println("proxy obj class ::"+proxy.getClass());
		System.out.println("super class::"+proxy.getClass().getSuperclass());
		System.out.println("Implemented interfaces::"+Arrays.toString(proxy.getClass().getInterfaces()));
		//invoke method
		System.out.println("Simple Intr Amount::"+proxy.calcSimpleIntrAmount(100000,12,2));
		System.out.println("...............................................");
		System.out.println("Simple Intr Amount::"+proxy.calcSimpleIntrAmount(100000,12, 2));
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
