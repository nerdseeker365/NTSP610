package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.FootBallPlayerService;

public class CallbackInterfacesTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		FootBallPlayerService service=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get SErvice class object
		service=ctx.getBean("fbService",FootBallPlayerService.class);
		//invoke methods
		System.out.println("1001 player Details ::"+service.searchPlayerById(1001));
		System.out.println("FORWARD Players info::"+service.searchPlayerRole("Forward"));
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
