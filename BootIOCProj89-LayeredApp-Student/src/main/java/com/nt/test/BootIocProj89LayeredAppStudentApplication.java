package com.nt.test;

import java.io.Closeable;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.config.AppConfig;
import com.nt.controller.MainController;
import com.nt.vo.StudentVO;

@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
@Import(value=AppConfig.class)
public class BootIocProj89LayeredAppStudentApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Scanner sc=null;
		String sno=null,sname=null,m1=null,m2=null,m3=null;
		StudentVO vo=null;
		MainController controller=null;
		String result=null;
		//read inputs
		sc=new Scanner(System.in);
		System.out.println("Enter name::");
		sname=sc.next();
		System.out.println("Enter marks1::");
		m1=sc.next();
		System.out.println("Enter marks2::");
		m2=sc.next();
		System.out.println("Enter marks3::");
		m3=sc.next();
		//create StudentVO class object
		vo=new StudentVO();
		 vo.setM1(m1); vo.setM2(m2);
		vo.setM3(m3); vo.setSname(sname);
		//create IOC container
		ctx=SpringApplication.run(BootIocProj89LayeredAppStudentApplication.class, args);
		//get Controller class object
		controller=ctx.getBean("controller",MainController.class);
		try {
			//invoke method
			result=controller.generateResult(vo);
					System.out.println("Result is :::"+result);
		}//try
		catch(Exception e) {
			if( ((SQLException)e).getErrorCode()==1) {
				System.out.println("Inter problem -->User Already registered" );
				e.printStackTrace();
			}
			else if(((SQLException)e).getErrorCode()==12899){
				System.out.println("Internal Problem---> Values are larger than colum size");
				e.printStackTrace();
			}
			else {
				System.out.println("Internal problem");
				 e.printStackTrace();
			}
		}//catch
		
		System.out.println("RealtimeDITest:: end of main()");
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}//main
}//class

