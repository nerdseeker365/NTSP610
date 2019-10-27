package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.service.BankService;

@SpringBootApplication
@Import(AppConfig.class)
public class TransactionMgmtTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BankService proxy=null;
		//create IOC container
		ctx=SpringApplication.run(TransactionMgmtTest.class, args);
		// get Bean
		proxy=ctx.getBean("bankService",BankService.class);
		System.out.println("proxy obj class name::"+proxy.getClass());
		
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
			System.out.println("Transfered Money?"+proxy.transferMoney(101,102, 2000));
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Internal Problem to transfermoney");
		}
		
		System.out.println("101 account balance::"+proxy.showBalance(101));
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
