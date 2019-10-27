package com.nt.beans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class WishMessageGenerator {
	@Autowired
	private  Date date;
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator::0-param constructor");
	}
	

	public   String  generateWishMessage(String user) {
		System.out.println("WishMessageGenerator::generateWishMessage(-)");
		int  hours=0;
		hours=date.getHours();
		if(hours<12)
			return "Good Morning::"+user;
		else if(hours<16)
			return "Good AfterNoon::"+user;
		else 
			return "Good Evening ::"+user;
		
	}

}
