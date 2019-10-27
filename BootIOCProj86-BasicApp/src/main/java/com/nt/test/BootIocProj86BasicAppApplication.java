package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.beans.WishMessageGenerator;
import com.nt.config.AppConfig;

@SpringBootApplication
@Import(AppConfig.class)
public class BootIocProj86BasicAppApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		WishMessageGenerator generator=null;
		//get IOC container
		ctx=SpringApplication.run(BootIocProj86BasicAppApplication.class, args);
		System.out.println(ctx.getClass());
		//get Target bean class obj
		generator=ctx.getBean("wmg",WishMessageGenerator.class);
		//invoke method
		System.out.println("message is::"+generator.generateWishMessage("raja"));
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}

