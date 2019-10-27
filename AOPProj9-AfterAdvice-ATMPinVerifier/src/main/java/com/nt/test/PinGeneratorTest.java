package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.target.ATMPInGenerator;

public class PinGeneratorTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ATMPInGenerator proxy=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean 
		proxy=ctx.getBean("pfb",ATMPInGenerator.class);
		try {
		//invoke the method
		System.out.println("Generated Pin ::"+proxy.generatePin());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
