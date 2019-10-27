package com.nt.beans;

public class BankService {
	private IntrestAmountDetails details;

	public void setDetails(IntrestAmountDetails details) {
		this.details = details;
	}
	
	public float  calcIntrAmount() {
		return (details.getPAmt()*details.getTime()*details.getRate())/100.0f;
	}

}
