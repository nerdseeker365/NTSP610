package com.nt.test;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	@Autowired
	  private  Calendar calendar;
	
	public  String  generateWishMessage(String user) {
		int hour=0;
		//get Current hour of the day
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		//generate wish message
		if(hour<12)
			return "Good Morning::"+user;
		else if(hour<16)
			return "Good AfterNoon::"+user;
		else if(hour<20)
			return "Good Evening::"+user;
		else
			return "Good Night::"+user;
	}//method
	
}//class
