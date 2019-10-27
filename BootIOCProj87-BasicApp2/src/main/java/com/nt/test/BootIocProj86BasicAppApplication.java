package com.nt.test;

import java.util.Calendar;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BootIocProj86BasicAppApplication {
	
	@Bean
	public   Calendar createCalendar() {
		return Calendar.getInstance();
		
	}

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		WishMessageGenerator generator=null;
		SpringApplication app=null;
		app=new SpringApplication( BootIocProj86BasicAppApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		ctx=app.run(args);
		
		//get IOC container
		/*ctx=SpringApplication.run(BootIocProj86BasicAppApplication.class, args);
		System.out.println(ctx.getClass());*/
		//get Target bean class obj
		generator=ctx.getBean("wmg",WishMessageGenerator.class);
		//invoke method
		System.out.println("message is::"+generator.generateWishMessage("raja"));
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}

