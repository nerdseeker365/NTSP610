package com.nt.advice;

import java.io.FileWriter;
import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class DiscountCuponAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		String cuponMsg=null;
		float billAmt=0.0f;
		FileWriter writer=null;
		//catch return value of b.method
		billAmt=(Float)returnValue;
		if(billAmt<=5000)
			cuponMsg="Avail 5% discount on next purchase";
		else if(billAmt<=10000)
			cuponMsg="Avail 10% discount on next purchase";
		else if(billAmt<=20000)
			cuponMsg="Avail 20% discount on next purchase";
		else
			cuponMsg="Avail 30% discount on next purchase";
		try {
		//write cuponMsg  to file...
		writer=new FileWriter("E:/cupon.txt");
		writer.write(cuponMsg);
		writer.flush();
		writer.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//method
}//class
