package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nt.beans.FirstFlight;
import com.nt.beans.Flipkart;

public class BeanCollabarationWithACTest {

	public static void main(String[] args) {
		Resource res=null;
		ApplicationContext ctx=null;
		Flipkart fpkt=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		/*//get Bean class obj
		fpkt=ctx.getBean("fpkt",Flipkart.class);
		System.out.println(fpkt.shopping(new String[] {"white Dress","CanvasVan","cap"}));
		*/
		
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
