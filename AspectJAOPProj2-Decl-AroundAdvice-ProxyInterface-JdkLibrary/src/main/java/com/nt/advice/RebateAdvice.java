package com.nt.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class RebateAdvice {
	
	public   Object rebate(ProceedingJoinPoint pjp)throws Throwable{
		Object retVal=null;
		Object args[]=null;
		args=pjp.getArgs();
		if( ((Float)args[0])<=50000)  //modifying target method retur value
			args[1]=((Float)args[1])-0.5f;
		retVal=pjp.proceed();
		//GST on Intr amount
		retVal=((Float)retVal)+((Float)retVal)*0.05f;
		return retVal;
	}

}
