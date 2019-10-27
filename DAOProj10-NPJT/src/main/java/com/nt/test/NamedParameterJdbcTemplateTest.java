package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

public class NamedParameterJdbcTemplateTest {

	public static void main(String[] args) {
		 ApplicationContext ctx=null;
		 EmployeeMgmtService service=null;
		 EmployeeDTO dto=null;
		 //create IOC container
		 ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		 //get Bean
		 service=ctx.getBean("empService",EmployeeMgmtService.class);
		 //invoke method
		 try {
			 System.out.println("7499 Emp Details:::"+service.searchEmpById(7499));
			 System.out.println(".....................................................");
			 System.out.println("CLERK,MANAGER,SALESMAN Desg Employee Details:::"+service.searchEmpsByDesgs("CLERK","MANAGER","SALESMAN"));
			 dto=new EmployeeDTO();
			 dto.setEno(9001);
			 dto.setEname("rajesh");
			 dto.setDesg("CLERK");
			 dto.setSalary(9000);
			 System.out.println(service.register(dto));
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 //close container
		 ((AbstractApplicationContext) ctx).close();

	}//main
}//class
