package com.nt.advice;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.ThrowsAdvice;

import com.nt.error.MyProblemException;

public class CommonExceptionGrapherAdvice implements ThrowsAdvice {

	
	
	

	
	
	

public  void afterThrowing(Method method,Object args[],Object target,IllegalArgumentException iae) throws MyProblemException {
		System.out.println(iae.toString()+"  exception is raised in the "+method.getName()+" method with args"+Arrays.toString(args)+"  in target class"+target.getClass().getName()+"--->4");
          //throw new  NumberFormatException(iae.getMessage());
		throw new  MyProblemException(iae.getMessage());
	}
	
	
	
	
	
	
	


	

}
