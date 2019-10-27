package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.AppConfig;
import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
@SpringBootApplication
@Import(value=AppConfig.class)
public class SimpleJdbcInsertTest {

	public static void main(String[] args) {
	     ApplicationContext ctx=null;
	     StudentService service=null;
	     StudentDTO dto=null;
	     
	     //create IOC container
	     ctx=SpringApplication.run(SimpleJdbcInsertTest.class, args);
	     //get Bean object
	     service=ctx.getBean("studService",StudentService.class);
	     //create DTO class object
	     dto=new StudentDTO();
	     dto.setSname("smallB");dto.setSadd("jaipur");
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
