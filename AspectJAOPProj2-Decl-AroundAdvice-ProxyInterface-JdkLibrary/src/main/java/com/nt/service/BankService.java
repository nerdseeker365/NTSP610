package com.nt.service;

public interface BankService {
	public float calcSimpleIntrAmount(float pAmt,float rate,float time);
	public float calcCompoundIntrAmount(float pAmt,float rate,float time);

}
