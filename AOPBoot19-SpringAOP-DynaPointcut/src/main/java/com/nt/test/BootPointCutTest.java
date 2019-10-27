package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.target.AirthmeticOperationsService;
@SpringBootApplication
@Import(AppConfig.class)
public class BootPointCutTest {
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		AirthmeticOperationsService proxy=null;
		//create IOC container
		ctx=SpringApplication.run(BootPointCutTest.class,args);
		//get Bean
		proxy=ctx.getBean("pfb",AirthmeticOperationsService.class);
		//invoke methods
		System.out.println("Add--->"+proxy.add(10000, 10000));
		System.out.println("-------------------");
		System.out.println("Add--->"+proxy.add(100, 100));
		System.out.println("-------------------");
		System.out.println("Sub--->"+proxy.sub(20000, 20000));
		System.out.println("-------------------");
		System.out.println("mul--->"+proxy.mul(10000, 10000));
		System.out.println("-------------------");
		System.out.println("mul--->"+proxy.mul(500, 500));
		System.out.println("-------------------");
		System.out.println("Div--->"+proxy.div(10000, 10000));
		System.out.println("-------------------");
		
		//close container
		((AbstractApplicationContext) ctx).close();
		
		
	}

}
