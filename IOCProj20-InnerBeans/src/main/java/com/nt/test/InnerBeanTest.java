package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.ProfessionalCricketer;

public class InnerBeanTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		ProfessionalCricketer cktr=null,cktr1=null;
		//create IOc container
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Target bean class obj
		cktr=factory.getBean("virat",ProfessionalCricketer.class);
		System.out.println(cktr.batting());
		System.out.println("..........................................");
		
	}

}
