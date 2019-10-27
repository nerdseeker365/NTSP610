package com.nt.test;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.PersonInfo;

public class NullInjectionTest {
     public static void main(String[] args) {
    	 DefaultListableBeanFactory factory=null;
    	 XmlBeanDefinitionReader  reader=null;
    	 PersonInfo info1=null,info2=null;
    	 //create IOC container
    	 factory=new DefaultListableBeanFactory();
    	 reader=new XmlBeanDefinitionReader(factory);
    	 reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
    	 //get Bean  obj
    	 info1=factory.getBean("sureshInfo",PersonInfo.class);
    	 System.out.println(info1);
    	 System.out.println("..................................");
    	 info2=factory.getBean("raoInfo",PersonInfo.class);
    	 System.out.println(info2);
		
	}
}
