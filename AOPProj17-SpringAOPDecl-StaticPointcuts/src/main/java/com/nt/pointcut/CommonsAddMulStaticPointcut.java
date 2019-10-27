package com.nt.pointcut;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import com.nt.target.AirthmeticOperationsService;

public class CommonsAddMulStaticPointcut extends StaticMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		if(targetClass==AirthmeticOperationsService.class) {
			if(method.getName().equalsIgnoreCase("add") || method.getName().equalsIgnoreCase("mul")){
				return true;
			}
		}
		return false;
	}

}
