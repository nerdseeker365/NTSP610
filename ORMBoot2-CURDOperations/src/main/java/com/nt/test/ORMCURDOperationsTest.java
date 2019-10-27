package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.config.AppConfig;
import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

@SpringBootApplication
@Import(AppConfig.class)
public class ORMCURDOperationsTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService service=null;
		EmployeeDTO dto=null;
		 //get IOC container
		ctx=SpringApplication.run(ORMCURDOperationsTest.class,args);
		//get Bean
		service=ctx.getBean("empMgmtService",EmployeeMgmtService.class);
		try {
		//invoke methods
		System.out.println("Emp Details ::::"+service.searchEmpByNo(9103));
		System.out.println("...................................");
		dto=new EmployeeDTO();
		dto.setEname("rajesh"); dto.setDesg("CLERK"); dto.setSalary(9000);
		System.out.println(service.registerEmp(dto)); 
		/*System.out.println("9102 Emp salary::"+service.findEmpSalary(9102));
		System.out.println(service.hikeEmpSalary(9102, 5.5f));
		System.out.println("9102 Emp salary::"+service.findEmpSalary(9102));
		System.out.println("...................................................");
		System.out.println(service.fireEmpsBySalaryRange(9001, 15000)); */
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
