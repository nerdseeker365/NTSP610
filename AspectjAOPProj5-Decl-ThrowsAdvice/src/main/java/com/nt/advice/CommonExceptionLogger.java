package com.nt.advice;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class CommonExceptionLogger {
	
	public  void   exceptionLogger(JoinPoint jp, IllegalArgumentException iae) {
		System.out.println(jp.getSignature()+" with args "+Arrays.toString(jp.getArgs())+" is having "+iae.toString()+" exception");
	}

}
