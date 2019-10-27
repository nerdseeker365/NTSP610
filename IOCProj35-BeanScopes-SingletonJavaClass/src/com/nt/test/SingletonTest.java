package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.Printer;

public class SingletonTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		Printer pu1=null,pu2=null;
	  //create IOC container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Bean class obj
		pu1=factory.getBean("pu",Printer.class);
		pu2=factory.getBean("pu",Printer.class);
		System.out.println(pu1.hashCode()+"   "+pu2.hashCode());
		System.out.println("pu1==pu2?"+(pu1==pu2));

	}

}
