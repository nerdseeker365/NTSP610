package com.nt.controller;

import java.util.Date;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class WishMessageGenerator extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Calendar calendar=null;
		int hour=0;
		String msg=null;
		ModelAndView mav=null;
		//get System Date and time
		calendar=Calendar.getInstance();
		//get current hour of the day
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		//generate wish MEssage
		if(hour<12)
			msg="Good Morning";
		else if(hour<16)
			msg="Good AfterNoon";
		else if(hour<20)
			msg="Good Evening";
		else
			msg="Good Night";
		//create MAV object
		mav=new ModelAndView();
		mav.addObject("msg",msg);
		mav.addObject("sysDate", new Date());
		mav.setViewName("result");
		
		return mav;
		
		

	}
	
	
	
}
