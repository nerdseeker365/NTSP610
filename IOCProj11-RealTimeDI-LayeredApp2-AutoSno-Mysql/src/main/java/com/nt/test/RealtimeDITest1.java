package com.nt.test;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.controller.MainController;
import com.nt.vo.StudentVO;

public class RealtimeDITest1 {

	public static void main(String[] args) {
		System.out.println("RealtimeDITest:: start of main()");
		Scanner sc=null;
		String sno=null,sname=null,m1=null,m2=null,m3=null;
		StudentVO vo=null;
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
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
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Controller class object
		controller=factory.getBean("controller",MainController.class);
		try {
			//invoke method
			result=controller.generateResult(vo);
					System.out.println("Result is :::"+result);
		}//try
		catch(Exception e) {
			if( ((SQLException)e).getErrorCode()==1) {
				System.out.println("Inter problem -->User Already registered" );
			}
			else if(((SQLException)e).getErrorCode()==12899){
				System.out.println("Internal Problem---> Values are larger than colum size");
			}
			else {
				System.out.println("Internal problem");
			}
		}//catch
		
		System.out.println("RealtimeDITest:: end of main()");
	}//main
}//class
