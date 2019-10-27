package com.nt.replacer;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("irr")
@PropertySource("classpath:com/nt/commons/replacer.properties")
public class IntrestRateReplacer implements MethodReplacer {
	@Value("${irate}")
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
