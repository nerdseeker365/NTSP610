package com.nt.replacer;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class IntrestRateReplacer implements MethodReplacer {
	private float rate;

	public void setRate(float rate) {
		this.rate = rate;
	}

	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		System.out.println("IntrestRateReplacer.reimplement(-,-,-)->new logics(simple)");
		float pAmt=0.0f,time=0.0f;
		//get Method arg values
		pAmt=(Float)args[0];
		time=(Float)args[1];
		return  pAmt*time*rate/100.0f;
	}

}
