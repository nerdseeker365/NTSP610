package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BillCalculator;

public class ThrowsAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		BillCalculator proxy=null;
		//create IOC contianer 
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy object
		proxy=ctx.getBean("pfb",BillCalculator.class);
		//invoke method
		try {
			System.out.println("Bill Amount::"+proxy.generateBillAmount("table", 9000,2));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("==============================");
		try {
			System.out.println("Bill Amount::"+proxy.generateBillAmount("table",0,0));
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
