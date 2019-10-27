package com.nt.target;

import java.util.Calendar;
import java.util.Random;

public class LoanApprover {
	
	public String approveLoan(String loanType,float loanAmount,String approver) {
		Calendar cal=null;
		int month=0;
		int loanId=0;
		//generated loanid
		loanId=new Random().nextInt(1000000);
		//get System date and time
		cal=Calendar.getInstance();
		month=cal.get(Calendar.MONTH);
		//write b.logic
		if(month>=6 && month<=11) {
			if(loanType.equalsIgnoreCase("argi")) {
				 if(loanAmount<=50000) {
					 return loanId+"  ->Loan Approved by:: "+approver+" for the amount::"+loanAmount+" and loanType:: "+loanType;
				 }
			}
		}
		  return loanId+"  ->Loan Rejected by:: "+approver+" for the amount::"+loanAmount+" and loanType:: "+loanType;   
	}//method

}//class
