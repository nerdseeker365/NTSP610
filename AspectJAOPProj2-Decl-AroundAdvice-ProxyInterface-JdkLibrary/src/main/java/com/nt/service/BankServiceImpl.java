package com.nt.service;

public class BankServiceImpl implements BankService {
	
	public  float  calcSimpleIntrAmount(float pAmt,float rate,float time) {
		return pAmt*rate*time/100.0f;
	}
	
	public  float  calcCompoundIntrAmount(float pAmt,float rate,float time) {
		return (float) (pAmt*Math.pow((1+rate/100),time))-pAmt;
	}

}
