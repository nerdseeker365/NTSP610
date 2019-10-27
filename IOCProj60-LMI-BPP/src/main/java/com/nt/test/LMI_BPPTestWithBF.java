package com.nt.test;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.service.RegistrationService;

public class LMI_BPPTestWithBF {

	public static void main(String[] args) {
		RegistrationService  service=null;
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		BeanPostProcessor bpp=null;
		//create IOC container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//register BeanPostPostProcessor with Container
		bpp=factory.getBean("dbpp",BeanPostProcessor.class);
		factory.addBeanPostProcessor(bpp);
		//get Service class object
		service=factory.getBean("regService",RegistrationService.class);
		System.out.println(service.getClass());
		service.registerEmployee("raja","vizag","programmer");
		System.out.println("......................");
		service.registerEmployee("rani","hyd","programmer");
		System.out.println("==========================");
		service.registerStudent("rama","vizag","java");
		System.out.println("......................");
		service.registerStudent("krishna","delhi","oracle");
		
	}

}
