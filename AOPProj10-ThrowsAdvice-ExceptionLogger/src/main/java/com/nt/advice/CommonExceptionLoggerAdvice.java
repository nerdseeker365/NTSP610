package com.nt.advice;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.ThrowsAdvice;

public class CommonExceptionLoggerAdvice implements ThrowsAdvice {

	
	
	
	public  void afterThrowing(Throwable th) {
		System.out.println(th.toString()+"  exception is raised -->3");
	}
	
	public  void afterThrowing(Exception iae) {
		System.out.println(iae.toString()+"  exception is raised -->2");
	}
	
	public  void afterThrowing(IllegalArgumentException iae) {
		System.out.println(iae.toString()+"  exception is raised -->1");
	}
	
	
	

	/*public  void afterThrowing(Method method,Object args[],Object target,IllegalArgumentException iae) {
		System.out.println(iae.toString()+"  exception is raised in the "+method.getName()+" method with args"+Arrays.toString(args)+"  in target class"+target.getClass().getName()+"--->4");
	}*/
	
	
	/*public  void afterThrowing(Method method,Object args[],Object target,Throwable iae) {
		System.out.println(iae.toString()+"  exception is raised in the "+method.getName()+" method with args"+Arrays.toString(args)+"  in target class"+target.getClass().getName()+"--->6");
	}
	
	public  void afterThrowing(Method method,Object args[],Object target,Exception iae) {
		System.out.println(iae.toString()+"  exception is raised in the "+method.getName()+" method with args"+Arrays.toString(args)+"  in target class"+target.getClass().getName()+"--->5");
	}*/
	
	
	
	
	


	

}
