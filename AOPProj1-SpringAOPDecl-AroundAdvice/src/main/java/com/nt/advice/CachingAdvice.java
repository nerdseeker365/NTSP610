package com.nt.advice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class CachingAdvice implements MethodInterceptor{
  private Map<String,Object> cache=new HashMap();
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String key=null;
		Object retVal=null;
		key=invocation.getMethod().getName()+""+Arrays.toString(invocation.getArguments());
		if(!cache.containsKey(key)) {
			retVal=invocation.proceed();
			cache.put(key, retVal);
			System.out.println("from target method");
		}
		else {
		retVal=cache.get(key);
		System.out.println("from cache");
		}
		return retVal;
	}

}
