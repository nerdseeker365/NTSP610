package com.nt.test;

import org.springframework.aop.framework.ProxyFactory;

import com.nt.advice.CachingAdvice;
import com.nt.advice.PerformenceMonitoringAdvice;
import com.nt.target.AirthmeticOperationsServiceImpl;
import com.nt.target.AirthmeticServiceOperations;

public class AOPProgramaticApp {

	public static void main(String[] args) {
		AirthmeticOperationsServiceImpl  target=null;
		PerformenceMonitoringAdvice advice1=null;
		ProxyFactory factory=null;
		AirthmeticServiceOperations proxy=null;
		CachingAdvice advice2=null;
		//create Target class object
		target=new AirthmeticOperationsServiceImpl();
		//create Advices class objects
		advice1=new PerformenceMonitoringAdvice();
		advice2=new CachingAdvice();
		//create ProxyFactory object 
		factory=new ProxyFactory();
		//set inputs
		factory.setTarget(target);
		factory.addAdvice(0,advice2);
		factory.addAdvice(1,advice1);
		factory.addInterface(AirthmeticServiceOperations.class);
		
		
		//get INMemory Proxy class object
		proxy=(AirthmeticServiceOperations) factory.getProxy();
		System.out.println("Proxy obj class name::"+proxy.getClass());
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
