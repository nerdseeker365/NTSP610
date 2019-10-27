package com.nt.test;

import java.util.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.beans.WishMessageGenerator;
import com.nt.config.AppConfig;

public class JavaConfigApproachTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=null;
		WishMessageGenerator generator=null;
		Date dt=null;
		//create IOC container
		//ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		ctx=new AnnotationConfigApplicationContext();
		/*ctx.scan("com.nt.config");
		ctx.refresh();*/
		ctx.register(AppConfig.class);
		ctx.refresh();
		//Get Bean
		generator=ctx.getBean("wishMessageGenerator",WishMessageGenerator.class);
		//invoke method
		System.out.println(generator.generateWishMessage("raja"));
		
		dt=ctx.getBean("createDate",Date.class);
		System.out.println(dt);
		
		
		//close container
		((AbstractApplicationContext) ctx).close();
		

	}

}
