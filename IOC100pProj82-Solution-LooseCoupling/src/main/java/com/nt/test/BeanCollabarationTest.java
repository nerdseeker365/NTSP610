package com.nt.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.io.Resource;

import com.nt.beans.Flipkart;
import com.nt.config.AppConfig;

public class BeanCollabarationTest {

	public static void main(String[] args) {
		Resource res=null;
		ApplicationContext ctx=null;
		Flipkart fpkt=null;
		//Hold Spring bean cfg file
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		fpkt=ctx.getBean("fpkt",Flipkart.class);
		//invoke b.method
		System.out.println(fpkt.shopping(new String[] {"long kurta","dandiya sticks","rold gold ","kolhapuri"}));
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}//main
}//class
