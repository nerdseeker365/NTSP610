package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.config.AppConfig;
import com.nt.service.PurchaseOrder;

@SpringBootApplication
@Import(AppConfig.class)
public class BootSpringMailApp1Application {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		PurchaseOrder order=null;
		//create IOC container
		ctx=SpringApplication.run(BootSpringMailApp1Application.class, args);
		//get Bean
		order=ctx.getBean("purchase",PurchaseOrder.class);
		try {
		//invoke method
		System.out.println(order.purchase(new String[] {"shirt","trouser","shoes"},"natarazworld@gmail.com"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}//main
}//class
