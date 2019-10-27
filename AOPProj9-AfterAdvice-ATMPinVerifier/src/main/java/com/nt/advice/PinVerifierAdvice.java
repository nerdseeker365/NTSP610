package com.nt.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class PinVerifierAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
	     int pin=(Integer)returnValue;
	     if(pin<=999)
	    	 throw new IllegalArgumentException("Invalid Pin Generation ");
	}

}
