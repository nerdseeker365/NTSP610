package com.nt.test;

import java.sql.SQLException;
import java.util.List;

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
public class SpringDataJpaApp1CurdRepositoryApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService service=null;
		List<EmployeeDTO> listDTO=null;
		EmployeeDTO dto1=null;
		//get Container
		ctx=SpringApplication.run(SpringDataJpaApp1CurdRepositoryApplication.class, args);
		//get service class object
		service=ctx.getBean("empService",EmployeeMgmtService.class);
		//invoke methods
		System.out.println("All Employess:::");
		listDTO=service.getAllEmployees();
		listDTO.forEach(dto->{
			System.out.println(dto);
		});
		System.out.println("............................");
		System.out.println("613 Employee :::"+service.getEmployeeById(24));
		System.out.println(".........................");
		System.out.println("CLERK,MANAGER desg Emps are"+service.getEmployeesByDesgs("CLERK", "MANAGER"));
		System.out.println(".....................");
		System.out.println("Emps Count::"+service.getEmployeesCount());
		System.out.println("................................");
		System.out.println("Salaries Total ::"+service.getEmployeesSalariesCount());
		try {
		dto1=new EmployeeDTO();
		dto1.setEname("ramesh"); dto1.setSalary(9000); dto1.setDesg("CLERK");
		System.out.println(service.registerEmployee(dto1));
		}
		catch(Exception se) {
			se.printStackTrace();
		}
		System.out.println(".....................................");
		try {
			System.out.println(service.addBonusToEmployeesByDesg("CLERK",1000));
			}
			catch(Exception se) {
				se.printStackTrace();
			}
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
	}//main
}//class
