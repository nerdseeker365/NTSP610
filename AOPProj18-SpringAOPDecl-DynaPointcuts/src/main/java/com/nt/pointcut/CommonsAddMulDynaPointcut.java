package com.nt.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import com.nt.target.AirthmeticOperationsService;

public class CommonsAddMulDynaPointcut extends DynamicMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass,Object... args) {
		if(targetClass==AirthmeticOperationsService.class) {
			if(method.getName().equalsIgnoreCase("add") || method.getName().equalsIgnoreCase("mul")){
				  if(((Float)args[0])>=1000 || ((Float)args[1])>=1000)
					  return true;
			}
		}
		return false;
	}

}
