package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.config.AppConfig;
import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

@SpringBootApplication
@Import(AppConfig.class)
public class SpringDataMangoDbApp3MongoRepoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService service=null;
		EmployeeDTO dto=null;
		//get Container
		ctx=SpringApplication.run(SpringDataMangoDbApp3MongoRepoApplication.class, args);
		//get Service class obj
		service=ctx.getBean("empService",EmployeeMgmtService.class);
		//invoke method
		/*dto=new EmployeeDTO();
		dto.setEno(103); dto.setEname("promod");  
		System.out.println(service.registerEmployee(dto));*/
		System.out.println(".......................");
		System.out.println("All Docs::: "+service.fetchAllEmployees());
		System.out.println(".......................");
		System.out.println(service.updateEmployee(103, "SSE", 100000));
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
