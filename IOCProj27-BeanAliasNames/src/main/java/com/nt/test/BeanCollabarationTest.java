package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nt.beans.Flipkart;

public class BeanCollabarationTest {

	public static void main(String[] args) {
		Resource res=null;
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		Flipkart fpkt=null;
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");

		//get Taget class obj injecting with Depedent class obj
		fpkt=factory.getBean("kart",Flipkart.class);
		//invoke b.method
		System.out.println(fpkt.shopping(new String[] {"long kurta","dandiya sticks","rold gold ","kolhapuri"}));

	}//main
}//class
