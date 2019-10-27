package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.target.AirthmeticOperationsService;

public class AOPDeclStaticPointCutTest {
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		AirthmeticOperationsService proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		proxy=ctx.getBean("pfb",AirthmeticOperationsService.class);
		//invoke methods
		System.out.println("Add--->"+proxy.add(10000, 10000));
		System.out.println("-------------------");
		System.out.println("Sub--->"+proxy.sub(20000, 20000));
		System.out.println("-------------------");
		System.out.println("mul--->"+proxy.mul(10000, 10000));
		System.out.println("-------------------");
		System.out.println("Div--->"+proxy.div(10000, 10000));
		System.out.println("-------------------");
		
		//close container
		((AbstractApplicationContext) ctx).close();
		
		
	}

}
