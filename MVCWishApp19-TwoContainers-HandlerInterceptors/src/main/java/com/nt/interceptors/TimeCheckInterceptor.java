package com.nt.interceptors;

import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TimeCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		Calendar cal=null;
		RequestDispatcher rd=null;
		int hour=0;
		//get System Date and time
		cal=Calendar.getInstance();
		//get current hour of the day
		hour=cal.get(Calendar.HOUR_OF_DAY);
		if(hour<9 || hour>17) {
			rd=req.getRequestDispatcher("/timeup.jsp");
			rd.forward(req,res);
			return false;
		}
		else {
			return true;
		}
	}//preHandle(-,-,-)
}//class
