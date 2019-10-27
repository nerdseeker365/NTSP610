package com.nt.test;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.nt.advice.PerformenceMonitoringAdvice;
import com.nt.pointcut.CommonAddMulMethodsPointcut;
import com.nt.target.AirthmeticOperationsService;

public class StaticPointCutTest {

	public static void main(String[] args) {
		AirthmeticOperationsService target=null,proxy=null;
		PerformenceMonitoringAdvice advice=null;
		CommonAddMulMethodsPointcut ptc=null;
		DefaultPointcutAdvisor advisor=null;
		ProxyFactory factory=null;
		
		//create Target class object
		target=new AirthmeticOperationsService();
		//create Advice class object
		advice=new PerformenceMonitoringAdvice();
		//create Pointcut class object
		ptc=new CommonAddMulMethodsPointcut();
		//create Advisor class object
		advisor=new DefaultPointcutAdvisor(ptc,advice);
		// create ProxyFactory class object
		factory=new ProxyFactory();
		factory.setTarget(target);
		factory.addAdvisor(advisor);
		//Get InMemory Proxy class object
		proxy=(AirthmeticOperationsService) factory.getProxy();
		//invoke methods...
		System.out.println("add===>"+proxy.add(100, 200));
		System.out.println("............");
		System.out.println("sub===>"+proxy.sub(100, 200));
		System.out.println("............");
		System.out.println("mul===>"+proxy.mul(100, 200));
		System.out.println("............");
		System.out.println("div===>"+proxy.div(100, 200));
		System.out.println("............");
	}//main
}//class
