package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.AirthmeticService;


public class PointcutTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		AirthmeticService  proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		proxy=ctx.getBean("arthService",AirthmeticService.class);
		//inovke the method
		System.out.println("sum::"+proxy.sum(10,20));
		System.out.println("________________________");
		System.out.println("sub::"+proxy.sub(30,20));
		System.out.println(".....................");
		
		System.out.println("Mul::"+proxy.mul(100, 200));
		System.out.println("__________________________");
		System.out.println("DIV::"+proxy.div(100, 0));
		System.out.println(".....................");
		//close container
		((AbstractApplicationContext) ctx).close();
	}
}
