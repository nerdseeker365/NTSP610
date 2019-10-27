package com.nt.advice;

import java.io.FileWriter;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

@Component("auditAdvice")
public class LoanAuditAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String auditMsg=null;
		FileWriter writer=null;
		System.out.println("target method::"+method.getName());
		System.out.println("Target method args::"+Arrays.toString(args));
		System.out.println("Target class name::"+target.getClass().getName());
		auditMsg="Loan came for approval at "+new Date()+" details are loanType::"+args[0]+" loanAmount::"+args[1]+" approver:: "+args[2]+"\n";
		//create Audit Log file
		writer=new FileWriter("F:/auditLog.txt",true);
		writer.write(auditMsg);
		writer.flush();
		writer.close();
	}//method
}//class
