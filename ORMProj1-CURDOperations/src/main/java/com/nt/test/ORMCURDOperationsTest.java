package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

public class ORMCURDOperationsTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService service=null;
		EmployeeDTO dto=null;
		 //create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		service=ctx.getBean("empMgmtService",EmployeeMgmtService.class);
		try {
		//invoke methods
		System.out.println("Emp Details ::::"+service.searchEmpByNo(9102));
		System.out.println("...................................");
	/*	dto=new EmployeeDTO();
		dto.setEname("rajesh"); dto.setDesg("CLERK"); dto.setSalary(9000);
		System.out.println(service.registerEmp(dto)); */
		System.out.println("9102 Emp salary::"+service.findEmpSalary(9102));
		System.out.println(service.hikeEmpSalary(9102, 5.5f));
		System.out.println("9102 Emp salary::"+service.findEmpSalary(9102));
		System.out.println("...................................................");
		System.out.println(service.fireEmpsBySalaryRange(9001, 15000));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
