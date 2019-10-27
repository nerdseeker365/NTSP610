package com.nt.target;

public final class BankServiceImpl implements BankService {
	
	public final  float  calcSimpleIntrAmount(float pAmt,float time,float rate) {
		return (pAmt*time*rate)/100.0f;
	}

}
