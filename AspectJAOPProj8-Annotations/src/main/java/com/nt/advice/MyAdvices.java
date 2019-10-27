package com.nt.advice;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("advice")
@Aspect
public class MyAdvices {
	  @Pointcut(value="execution( *  com.nt.service.AirthmeticService.*(..))")
      public  void myPtc(){
		  System.out.println("MyAdvices.myPtc()");
       }

     @Before(value="myPtc()")
     public    void checkInputs(JoinPoint jp)throws Throwable{
    	 System.out.println("MyAdvices.checkInputs()");
        Object args[]=null;
        args=jp.getArgs();
        if(((Float)args[0])<=0 ||  ((Float)args[1])<=0)
        	throw new IllegalArgumentException("Invalid inputs");
      }

    @Around(value="myPtc()")
    public  Object   monitor(ProceedingJoinPoint pjp)throws Throwable{
    	System.out.println("MyAdvices.monitor()");
    	long start=0,end=0;
        Object retVal=null;
         start=System.currentTimeMillis();
         retVal=pjp.proceed();
          end=System.currentTimeMillis();
          System.out.println(pjp.getSignature()+"with args"+Arrays.toString(pjp.getArgs())+" has taken "+(end-start)+"  ms.");
         return retVal;
       }

   @AfterReturning(value="myPtc()",
                                       returning="result")
    public   void  checkResult(JoinPoint jp , float result){
	   System.out.println("MyAdvices.checkResult()");
       if(result<=0)
    	   throw new IllegalArgumentException("invalid reuslt");
    	   
       }
 @AfterThrowing(value="myPtc()",
                                   throwing="ex")
    public   void  expLogger(JoinPoint jp ,Exception ex){
	 System.out.println("MyAdvices.expLogger()");
       System.out.println(ex.toString()+" exception is raised in"+jp.getSignature()+" with args"+Arrays.toString(jp.getArgs()));
       }
}
