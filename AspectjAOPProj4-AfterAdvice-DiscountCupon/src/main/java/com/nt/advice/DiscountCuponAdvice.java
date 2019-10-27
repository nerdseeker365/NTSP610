package com.nt.advice;

import java.io.FileWriter;

import org.aspectj.lang.JoinPoint;

public class DiscountCuponAdvice {
	
	public   void  cuponGenerator(JoinPoint jp,float billAmt)throws Throwable{
		String cuponMsg=null;
		FileWriter writer=null;
		if(billAmt<=5000)
			cuponMsg="Avail 5% discount on next purchase";
		else if(billAmt<=10000)
			cuponMsg="Avail 10% discount on next purchase";
		else if(billAmt<=20000)
			cuponMsg="Avail 20% discount on next purchase";
		else
			cuponMsg="Avail 30% discount on next purchase";
		//write cupon Message
		writer=new FileWriter("F:/cupont.txt");
		writer.write(cuponMsg);
		writer.flush();
		writer.close();
	}//method
}//class
