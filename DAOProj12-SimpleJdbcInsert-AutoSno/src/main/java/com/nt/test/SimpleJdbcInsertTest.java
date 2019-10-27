package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.bo.StudentBO;
import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

public class SimpleJdbcInsertTest {

	public static void main(String[] args) {
	     ApplicationContext ctx=null;
	     StudentService service=null;
	     StudentDTO dto=null;
	     //create IOC container
	     ctx=new  ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	     //get Bean object
	     service=ctx.getBean("studService",StudentService.class);
	     //create DTO class object
	     dto=new StudentDTO();
	     dto.setSname("BigB");dto.setSadd("mumbai");
	     try {
	     //invoke the method
	     System.out.println(service.register(dto));
	     }
	     catch(Exception e) {
	    	 e.printStackTrace();
	     }
	     
	     //close container
	     ((AbstractApplicationContext) ctx).close();

	}

}
