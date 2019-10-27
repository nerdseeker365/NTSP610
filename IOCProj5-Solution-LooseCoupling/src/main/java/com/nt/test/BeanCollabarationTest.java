package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nt.beans.Flipkart;

public class BeanCollabarationTest {

	public static void main(String[] args) {
		Resource res=null;
		BeanFactory factory=null;
		Flipkart fpkt=null;
		//Hold Spring bean cfg file
		res=new ClassPathResource("com/nt/cfgs/applicationContext.xml");
		//create IOC container
		factory=new XmlBeanFactory(res);
		//get Taget class obj injecting with Depedent class obj
		//fpkt=(Flipkart)factory.getBean("fpkt");
		Class c=Flipkart.class;
		//fpkt=factory.getBean("fpkt",Flipkart.class);
		fpkt=factory.getBean("fpkt",c);
		//invoke b.method
		System.out.println(fpkt.shopping(new String[] {"long kurta","dandiya sticks","rold gold ","kolhapuri"}));

	}//main
}//class
