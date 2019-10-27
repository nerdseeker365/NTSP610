//Spring Bean class (POJO class)
package com.nt.beans;

import java.util.Date;

public class WishMessageGenerator {
	 private Date  date;
	 
	/* private void setDate(Date date) {
		 System.out.println("setDate(-)");
		 this.date=date;
	 }
	*/
	   
	
	private WishMessageGenerator(Date date) {
		this.date=date;
		System.out.println("WishMessageGenerator.1-param constructor(private)");
	}

	public String sayHello(String user) {
		System.out.println("Injected date is::"+date);
		return "Good Morning::"+user;
		
	}
}
