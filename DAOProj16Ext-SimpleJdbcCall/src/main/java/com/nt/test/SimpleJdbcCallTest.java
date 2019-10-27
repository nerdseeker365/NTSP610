package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.dto.UserDTO;
import com.nt.service.AuthenticationService;

public class SimpleJdbcCallTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		AuthenticationService service=null;
		UserDTO dto=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service class object
		service=ctx.getBean("authService",AuthenticationService.class);
		//invoke the method
		try {
			//prepare DTO
			dto=new UserDTO();
			dto.setUsername("raja"); dto.setPassword("rani1");
			System.out.println(service.login(dto));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
