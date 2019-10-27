package com.nt.service;

public class ShoppingStore {
	
	public  float shopping(String itemName ,float rate,float qty) {
		float billAmt=0.0f;
		if(rate<=0 || qty<=0.0f)
			throw  new IllegalArgumentException("Invalid inputs");
		billAmt=rate*qty;
		return billAmt;
	}

}
