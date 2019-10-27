package com.nt.test;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.BankService;

public class CustomPETestBF3 {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		BankService service=null;
		CustomEditorConfigurer configurer=null;
		//create IOC container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Access to  CustomEditorConfigurer
		configurer=factory.getBean("cec",CustomEditorConfigurer.class);
		configurer.postProcessBeanFactory(factory);
		
		//get Bean
		service=factory.getBean("bankService",BankService.class);
		//invoke method
		System.out.println("Intr Amount::"+service.calcIntrAmount());
	}//main
	
}//class
