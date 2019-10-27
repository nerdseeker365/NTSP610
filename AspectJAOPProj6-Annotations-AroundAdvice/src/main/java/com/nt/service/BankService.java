package com.nt.service;

import org.springframework.stereotype.Service;

@Service("bankService")
public class BankService {
	
	public  float  calcSimpleIntrAmount(float pAmt,float rate,float time) {
		return pAmt*rate*time/100.0f;
	}
	
	public  float  calcCompoundIntrAmount(float pAmt,float rate,float time) {
		return (float) (pAmt*Math.pow((1+rate/100),time))-pAmt;
	}

}
