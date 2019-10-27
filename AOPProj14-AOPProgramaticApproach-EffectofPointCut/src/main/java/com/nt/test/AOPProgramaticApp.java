package com.nt.test;

import java.lang.reflect.Method;

import org.springframework.aop.framework.ProxyFactory;

import com.nt.advice.PerformenceMonitoringAdvice;
import com.nt.target.AirthmeticOperationsService;

public class AOPProgramaticApp {

	public static void main(String[] args) {
		AirthmeticOperationsService  target=null;
		PerformenceMonitoringAdvice advice1=null;
		ProxyFactory factory=null;
		AirthmeticOperationsService proxy=null;	
		//create Target class object
		target=new AirthmeticOperationsService();
		//create Advices class objects
		advice1=new PerformenceMonitoringAdvice();
		//create ProxyFactory object 
		factory=new ProxyFactory();
		//set inputs
		factory.setTarget(target);
		factory.addAdvice(advice1);
		
		
		//get INMemory Proxy class object
		proxy=(AirthmeticOperationsService) factory.getProxy();
		System.out.println("Proxy obj class name::"+proxy.getClass());
		System.out.println("method of proxy class");
		Method methods[]=proxy.getClass().getDeclaredMethods();
		for(Method method:methods) {
			System.out.println(method.getName());
		}
		//invoke methods
		System.out.println("add==>"+proxy.add(10,20));
		System.out.println("-------------------------------");
		System.out.println("sub==>"+proxy.sub(10,20));
		System.out.println("-------------------------------");
		System.out.println("mul==>"+proxy.mul(10,20));
		System.out.println("......................................");
		System.out.println("div==>"+proxy.div(10,20));
		System.out.println("......................................");
		System.out.println("div==>"+proxy.div(10,20));
		
	}
}
