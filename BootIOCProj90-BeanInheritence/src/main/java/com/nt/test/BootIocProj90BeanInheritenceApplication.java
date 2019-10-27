package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.beans.Car;
import com.nt.config.AppConfig;

@SpringBootApplication
@Import(AppConfig.class)
public class BootIocProj90BeanInheritenceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Car car1=null,car2=null;
		ctx=SpringApplication.run(BootIocProj90BeanInheritenceApplication.class, args);
		//get Bean class obj
		car1=ctx.getBean("car1",Car.class);
		System.out.println(car1);
		System.out.println("....................");
		car2=ctx.getBean("car2",Car.class);
		System.out.println(car2);
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
	}

}

