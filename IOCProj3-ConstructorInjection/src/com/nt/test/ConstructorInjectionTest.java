package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nt.beans.WishMessageGenerator;

public class ConstructorInjectionTest {

	public static void main(String[] args) {
		Resource res=null;
		 BeanFactory factory=null;
		 WishMessageGenerator generator=null;
		//Hold spring bean cfg file
		 //res=new ClassPathResource("com/nt/cfgs/applicationContext.xml");
		 res=new ClassPathResource("applicationContext.xml");
		//create IOC container
		//factory=new XmlBeanFactory(new FileSystemResource("src/com/nt/cfgs/applicationContext.xml"));
		 //factory=new XmlBeanFactory(new FileSystemResource("E:\\Springws\\NTSP610\\IOCProj3-ConstructorInjection\\src\\com\\nt\\cfgs\\applicationContext.xml"));
		  factory=new XmlBeanFactory(res);
		//get Target class obj
		generator=(WishMessageGenerator) factory.getBean("wmg");
		//invoke b.method
		System.out.println("Message:::"+generator.sayHello("raja"));
	}

}
