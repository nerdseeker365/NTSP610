package com.nt.advice;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Date;

import org.aspectj.lang.JoinPoint;

public class AuditingAdvice {
	
	public void   auditing(JoinPoint jp)throws Throwable{
		String auditMsg=null;
		Object args[]=null;
		Writer writer=null;
		//get target method ags
		args=jp.getArgs();
		args[1]=((Float)args[1])+100;
		auditMsg=args[0]+ "  loan type loan applicaiton has come for  approval for the amount     "+args[1]+" to the approver  "+args[2]+" on date"+new Date()+"\n";
		//write the audit Log message to the file
		writer=new FileWriter("F:/auditLog.txt",true);
		writer.write(auditMsg);
		writer.flush();
		writer.close();
		
	}
	
/*	public void   auditing(JoinPoint jp,String ltype,float amt,String appvr)throws Throwable{
		String auditMsg=null;
		Writer writer=null;
		//get target method ags
		auditMsg=ltype+ "  loan type loan applicaiton has come for  approval for the amount     "+amt+"  to the approver  "+ appvr+" on date"+new Date()+"\n";
		//write the audit Log message to the file
		writer=new FileWriter("F:/auditLog.txt",true);
		writer.write(auditMsg);
		writer.flush();
		writer.close();
	} */
	
	/*public void   auditing(String ltype,float amt,String appvr)throws Throwable{
		String auditMsg=null;
		Writer writer=null;
		//amt=amt+100;
		//get target method ags
		auditMsg=ltype+ "  loan type loan applicaiton has come for  approval for the amount     "+amt+"  to the approver  "+ appvr+" on date"+new Date()+"\n";
		//write the audit Log message to the file
		writer=new FileWriter("F:/auditLog.txt",true);
		writer.write(auditMsg);
		writer.flush();
		writer.close();
	}*/

}
