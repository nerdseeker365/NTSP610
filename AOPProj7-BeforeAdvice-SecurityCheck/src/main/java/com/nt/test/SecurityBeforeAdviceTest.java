package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.manager.AuthenticationManager;
import com.nt.service.BankService;

public class SecurityBeforeAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		AuthenticationManager manager=null;
		BankService  proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get AuthenticationManager object
		manager=ctx.getBean("authManager",AuthenticationManager.class);
		//get Proxy object
		proxy=ctx.getBean("pfb",BankService.class);
		try {
			//invoke methods
			 //singnIN
			manager.signIn("raja","rani1");
			//b.method
			System.out.println(proxy.withdrawMoney(1111, 1000));
			//singOUT
			manager.signOut();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
