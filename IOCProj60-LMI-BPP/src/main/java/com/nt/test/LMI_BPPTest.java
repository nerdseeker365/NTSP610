package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.RegistrationService;

public class LMI_BPPTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		RegistrationService  service=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service class object
		service=ctx.getBean("regService",RegistrationService.class);
		System.out.println(service.getClass());
		service.registerEmployee("raja","vizag","programmer");
		System.out.println("......................");
		service.registerEmployee("rani","hyd","programmer");
		System.out.println("==========================");
		service.registerStudent("rama","vizag","java");
		System.out.println("......................");
		service.registerStudent("krishna","delhi","oracle");
		
		//close container
		((AbstractApplicationContext) ctx).close();
		

	}

}
