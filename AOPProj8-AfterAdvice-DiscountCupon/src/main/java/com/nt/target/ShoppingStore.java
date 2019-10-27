package com.nt.target;

public class ShoppingStore {
	
	public float   shopping(String items[],float prices[]) {
		float billAmt=0.0f;
		for(int i=0;i<prices.length;++i) {
			billAmt=billAmt+prices[i];
		}
		return billAmt;
	}//method
}//class
