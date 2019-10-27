package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.ShoppingStore;

public class ThrowsAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ShoppingStore proxy=null;
		
		//create IOCContainer
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean class object
		proxy=ctx.getBean("store",ShoppingStore.class);
		//invoke the methods
		try {
			System.out.println("Bill Amount::"+proxy.shopping("table",1000, 2));
		}
		catch(IllegalArgumentException ex) {
			ex.printStackTrace();
		}
		System.out.println("==============================");
		try {
			System.out.println("Bill Amount::"+proxy.shopping("table",0, 0));
		}
		catch(IllegalArgumentException ex) {
			ex.printStackTrace();
		}
		
		
        //close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
