package com.nt.advice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

public class CachingAdvice {
	 private Map<String,Object> cache=new HashMap();
	public  Object   caching(ProceedingJoinPoint pjp)throws Throwable{
		String key=null;
		Object retVal=null;
		key=pjp.getSignature()+""+Arrays.toString(pjp.getArgs());
		if(!cache.containsKey(key)) {
			retVal=pjp.proceed();
			cache.put(key,retVal);
			System.out.println("from target method");
			return retVal;
		}
		else {
			System.out.println("from Cache");
		   return cache.get(key);
		}
	}//method
}//class
