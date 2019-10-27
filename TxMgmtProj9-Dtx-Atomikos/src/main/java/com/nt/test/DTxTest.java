package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;

public class DTxTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		//create  IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		proxy=ctx.getBean("bankService",BankService.class);
		//invoke methods
		try {
			System.out.println("TransferedMoney? :::"+proxy.transferMoney(1005, 1002, 1000));
			System.out.println("TX committed");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("TX rolledback");
		}
		//close container
		((AbstractApplicationContext) ctx).close();
		

	}

}
