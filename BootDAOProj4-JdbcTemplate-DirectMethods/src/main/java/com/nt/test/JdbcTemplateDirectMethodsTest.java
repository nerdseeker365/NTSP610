package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.config.AppConfig;
import com.nt.service.EmployeeService;

@SpringBootApplication
@Import(AppConfig.class)
public class JdbcTemplateDirectMethodsTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeService  service=null;
		//create IOC container
		ctx=SpringApplication.run(JdbcTemplateDirectMethodsTest.class,args);
		//get Bean
		service=ctx.getBean("empService",EmployeeService.class);
		//invoke methods
		try {
        	System.out.println("Emps Count::"+service.fetchEmpsCount());
        	System.out.println("..............");
        	System.out.println("Emp name::"+service.fetchEmpNameById(7499));
        	System.out.println("...................");
        	System.out.println("7499 Emp Details ::"+service.fetchEmpDetailsById(7499));
        	System.out.println(".......................");
        	System.out.println("CLERK Desg Emp Detials::"+service.fetchEmpDetailsDesg("CLERK"));
        	//System.out.println(service.registerEmployee(1001,"Raja", "CLERK",8000));
        	//System.out.println(service.fireEmployee(1001));
        	//System.out.println(service.addPongalBonus(2000,5000, 10000));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
     //close container
		((AbstractApplicationContext) ctx).close();
	}

}
