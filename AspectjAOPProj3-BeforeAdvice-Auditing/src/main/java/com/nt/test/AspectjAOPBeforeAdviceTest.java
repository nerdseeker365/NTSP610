package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.LoanApprover;

public class AspectjAOPBeforeAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		LoanApprover proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy object
		proxy=ctx.getBean("approver",LoanApprover.class);
		//invoke the methods
		System.out.println(proxy.approveLoan("agri", 90000, "manager"));
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
