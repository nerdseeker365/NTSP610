package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.AccountHolder;
import com.nt.beans.Marks;
import com.nt.beans.Student;

public class ConstructorInjectionTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		Student stud=null;
		Marks mk=null;
		AccountHolder holder=null;
		//create  IOC container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Target Bean class object
		stud=factory.getBean("stud",Student.class);
		System.out.println(stud);
		System.out.println("........................................");
		mk=factory.getBean("mk",Marks.class);
		System.out.println(mk);
		System.out.println("........................................");
		holder=factory.getBean("holder",AccountHolder.class);
		System.out.println(holder);
		
	}//main
}//class
