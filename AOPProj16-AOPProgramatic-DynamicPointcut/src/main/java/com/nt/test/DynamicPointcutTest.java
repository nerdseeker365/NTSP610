package com.nt.test;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.nt.advice.PerformenceMonitoringAdvice;
import com.nt.pointcut.CommonDynaAddMulPointcut;
import com.nt.target.AirthmeticOperationsService;

public class DynamicPointcutTest {

	public static void main(String[] args) {
		AirthmeticOperationsService target=null,proxy=null;
		PerformenceMonitoringAdvice pmAdvice=null;
		CommonDynaAddMulPointcut ptc=null;
		DefaultPointcutAdvisor advisor1=null;
		ProxyFactory factory=null;
		//create Targt class object
		target=new AirthmeticOperationsService();
		//create Advice class object
		pmAdvice=new PerformenceMonitoringAdvice();
		//create Pointcut class
		ptc=new CommonDynaAddMulPointcut();
		//create Advisor
		advisor1=new DefaultPointcutAdvisor(ptc,pmAdvice);
		//create ProxyFactory 
		factory=new ProxyFactory();
		factory.setTarget(target);
		factory.addAdvisor(advisor1);
		//get Proxy class object
		proxy=(AirthmeticOperationsService) factory.getProxy();
		//invoke methods
		 System.out.println("Add====>"+proxy.add(100,200));
		 System.out.println(".............................");
		 System.out.println("Add====>"+proxy.add(1000,2000));
		 System.out.println(".............................");
		 System.out.println("Sub====>"+proxy.sub(100,200));
		 System.out.println(".............................");
		 System.out.println("Mul====>"+proxy.mul(100,200));
		 System.out.println(".............................");
		 System.out.println("Mul====>"+proxy.mul(1000,2000));
		 System.out.println(".............................");
		 System.out.println("Div====>"+proxy.div(100,200));
		 System.out.println(".............................");
	}//main
}//class
