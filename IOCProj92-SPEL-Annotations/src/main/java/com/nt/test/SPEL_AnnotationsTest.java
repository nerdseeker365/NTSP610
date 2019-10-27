package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Tourist;

public class SPEL_AnnotationsTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Tourist tourist=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		tourist=ctx.getBean("tourist",Tourist.class);
		System.out.println(tourist);
		
		//close container
		((AbstractApplicationContext) ctx).close();
		

	}

}
