package com.nt.advice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component("cacheAdvice")
@Order(1)
public class CachingAdvice {
	 private Map<String,Object> cache=new HashMap();
	
	 @Around(value="execution(float com.nt.service.BankService.calc*(..))")
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
