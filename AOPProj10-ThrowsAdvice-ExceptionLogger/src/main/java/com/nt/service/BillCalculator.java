package com.nt.service;

public class BillCalculator {
	
	public   float   generateBillAmount(String item,float price,float qty) {
		if(item==null || price<=0.0f || qty<=0.0f)
			throw  new  IllegalArgumentException("Invalid inputs");
		return  price*qty;
	}

}
