package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;

public class TransactionMgmtTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		// get Bean
		proxy=ctx.getBean("tpfb",BankService.class);
		//invoke b.method
	/*	try {
			System.out.println("Money withdrawn?"+proxy.withdrawMoney(101,1000));
		}
		catch(Exception e) {
			System.out.println("Internal Problem to withdraw money");
		}
		System.out.println("..................................................");
		try {
			System.out.println("Money Deposited?"+proxy.depositeMoney(102, 1000));
		}
		catch(Exception e) {
			System.out.println("Internal Problem to deposite money");
		} 
		System.out.println("....................................................."); */
		
		try {
			System.out.println("Transfered Money?"+proxy.transferMoney(108,102, 2000));
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Internal Problem to transfermoney");
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
