package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.PersonDetails;

public class PropertyEditorTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		PersonDetails details=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//ctx=new FileSystemXmlApplicationContext("src/main/java/com/nt/cfgs/applicationContext.xml");
		//get Bean class obj
		details=ctx.getBean("pDetails",PersonDetails.class);
		System.out.println(details);
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
