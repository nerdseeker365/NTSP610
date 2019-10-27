package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.target.LoanApprover;

@SpringBootApplication
@Import(AppConfig.class)
public class BeforeAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		LoanApprover proxy=null;
		//create IOC container
		ctx=SpringApplication.run(BeforeAdviceTest.class, args);
		//get Proxy object
		proxy=ctx.getBean("pfb",LoanApprover.class);
		//invoke method
		System.out.println(proxy.approveLoan("argi",50000,"Another anand"));
	//close container
		((AbstractApplicationContext) ctx).close();
		

	}

}
