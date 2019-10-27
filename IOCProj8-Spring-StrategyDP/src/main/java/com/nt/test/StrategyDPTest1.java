package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.beans.Viechle;


public class StrategyDPTest1{

	public static void main(String[] args) {
		BeanFactory factory=null;
		Viechle viechle=null;
		//create IOC container
		factory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
		//Get Target class obj having Dependent class obj
		viechle=factory.getBean("viechle",Viechle.class);
		viechle.journey("hyd","mumbai");
		System.out.println(".....................");
		viechle=factory.getBean("viechle",Viechle.class);
		viechle.journey("hyd","Delhi");
	}

}
