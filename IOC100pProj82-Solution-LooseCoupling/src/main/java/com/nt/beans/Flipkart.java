package com.nt.beans;

import java.util.Arrays;
import java.util.Random;

import javax.annotation.Resource;
import javax.inject.Named;

@Named("fpkt")
public class Flipkart {
	@Resource(name="dtdc")
	private Courier courier;
	

	public Flipkart() {
		System.out.println("Flipkart::0-param constructor");
	}
	
	public  String shopping(String[] items) {
		System.out.println("Flipkart:: shopping(-)");
		float billAmt=0.0f;
		Random rad=null;
		int oid=0;
		//calc bill Amount
		billAmt=items.length*1000;
		//generate orderId
		rad=new Random();
		oid=rad.nextInt(10000);
		//deliver product
		//dtdc.deliver(oid);
		courier.deliver(oid);
		return Arrays.toString(items)+" Bill Amount:: "+billAmt;
	}
	

}
