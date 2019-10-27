package com.nt.test;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

import com.nt.advice.CachingAdvice;
import com.nt.advice.PerformenceMonitoringAdvice;
import com.nt.pointcut.CommonAddMulMethodsPointcut;
import com.nt.target.AirthmeticOperationsService;

public class StaticPointCutTest2 {

	public static void main(String[] args) {
		AirthmeticOperationsService target=null,proxy=null;
		PerformenceMonitoringAdvice pmAdvice=null;
		CommonAddMulMethodsPointcut ptc=null;
		DefaultPointcutAdvisor advisor=null;
		NameMatchMethodPointcutAdvisor advisor1=null;
		ProxyFactory factory=null;
		CachingAdvice  cachingAdvice=null;
		NameMatchMethodPointcut ptc1=null;
		
		//create Target class object
		target=new AirthmeticOperationsService();
		//create Advice class object
		pmAdvice=new PerformenceMonitoringAdvice();
		cachingAdvice=new CachingAdvice();
		//create Pointcut class object
		ptc=new CommonAddMulMethodsPointcut();
		//create Advisor class object
		advisor=new DefaultPointcutAdvisor(ptc,pmAdvice);
		advisor1=new NameMatchMethodPointcutAdvisor(cachingAdvice);
		advisor1.setMappedNames("mul");
		// create ProxyFactory class object
		factory=new ProxyFactory();
		factory.setTarget(target);
		factory.addAdvisor(advisor1);
		factory.addAdvisor(advisor);
		//Get InMemory Proxy class object
		proxy=(AirthmeticOperationsService) factory.getProxy();
		//invoke methods...
		System.out.println("add===>"+proxy.add(100, 200));
		System.out.println("add===>"+proxy.add(100, 200));
		System.out.println("............");
		System.out.println("sub===>"+proxy.sub(100, 200));
		System.out.println("sub===>"+proxy.sub(100, 200));
		System.out.println("............");
		System.out.println("mul===>"+proxy.mul(100, 200));
		System.out.println("mul===>"+proxy.mul(100, 200));
		System.out.println("............");
		System.out.println("div===>"+proxy.div(100, 200));
		System.out.println("div===>"+proxy.div(100, 200));

		System.out.println("............");
	}//main
}//class
