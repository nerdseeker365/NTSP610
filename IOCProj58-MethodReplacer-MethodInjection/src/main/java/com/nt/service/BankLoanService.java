package com.nt.service;

public class BankLoanService {
	
	public   float  calcIntrAmt(float pAmt,float time) {
		System.out.println("BankLoanService.calcIntrAmt(-,-)-->real logics(compound)");
		return  (float) (pAmt*Math.pow(1+2.0f/100,time))-pAmt;
		
	}

}
