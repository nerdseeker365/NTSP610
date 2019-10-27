package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Viechle;

public class DependencyLookupTest {

	public static void main(String[] args) {
		System.out.println("main(-)");
		ApplicationContext ctx=null;
	    Viechle viechle=null;
		//create IOC container
	    ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		System.out.println("----IOC container of Client App is created----");
		//get Target class object
		viechle=ctx.getBean("viechle",Viechle.class);
		//invoke methods
		viechle.journey("hyd","warangal");
		viechle.entertainment();
		viechle.soundHorn();
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
