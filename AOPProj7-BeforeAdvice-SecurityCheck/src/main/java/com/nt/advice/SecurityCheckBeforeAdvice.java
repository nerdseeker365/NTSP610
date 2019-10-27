package com.nt.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nt.manager.AuthenticationManager;

@Component("securityAdvice")
public class SecurityCheckBeforeAdvice implements MethodBeforeAdvice {
	@Autowired
	private  AuthenticationManager manager;

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
	  if(!manager.validate())
		  throw new IllegalArgumentException("Invalid Credentials");

	}

}
