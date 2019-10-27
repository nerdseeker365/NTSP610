package com.nt.target;

public class BankService {
	
	public  float  calcSimpleIntrAmount(float pAmt,float time,float rate) {
		return (pAmt*time*rate)/100.0f;
	}

}
