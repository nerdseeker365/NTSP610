package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.Engine;
import com.nt.beans.Viechle;

public class DependencyLookupTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
	    Viechle viechle=null;
		//create IOC container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		System.out.println("IOC container of Client App is created");
		//get Target class object
		viechle=factory.getBean("viechle",Viechle.class);
		//invoke methods
		viechle.journey("hyd","warangal");
		viechle.entertainment();
		viechle.soundHorn();
		
	}

}
