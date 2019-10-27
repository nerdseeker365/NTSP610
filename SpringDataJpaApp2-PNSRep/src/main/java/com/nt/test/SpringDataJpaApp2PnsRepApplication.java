package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.config.AppConfig;
import com.nt.service.EmployeeMgmtService;

@SpringBootApplication
@Import(AppConfig.class)
public class SpringDataJpaApp2PnsRepApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService service=null;
		//get IOC container
		ctx=SpringApplication.run(SpringDataJpaApp2PnsRepApplication.class, args);
		//get Service class obj
		service=ctx.getBean("empService",EmployeeMgmtService.class);
		//invoke methods
		service.fetchAllEmployees(3);
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
