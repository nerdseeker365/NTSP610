package com.nt.test;

import java.util.List;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.College;
import com.nt.beans.FruitShop;
import com.nt.beans.PersonInfo;
import com.nt.beans.Student;
import com.nt.beans.University;

public class CollectionInjectionTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory  factory=null;
		XmlBeanDefinitionReader reader=null;
		Student stud=null;
		College clg=null;
		PersonInfo info=null;
		University university=null;
		FruitShop fruit=null;
		//create IOC container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Bean calss object
		stud=factory.getBean("stud",Student.class);
		//invoke methods
		System.out.println(stud);

		System.out.println(".........................................................");
		clg=factory.getBean("clg",College.class);
		System.out.println(clg);
		
		System.out.println(".......................................");
		info=factory.getBean("perInfo",PersonInfo.class);
		System.out.println(info);
		System.out.println("....................................");
		university=factory.getBean("university",University.class);
		System.out.println(university);
		System.out.println("................................");
		fruit=factory.getBean("fs",FruitShop.class);
		System.out.println(fruit);
		System.out.println("............................");
		List<String> list=factory.getBean("emails",List.class);
		System.out.println(list.toString());
		System.out.println(list.getClass());
		
		
	}//main
}//class
