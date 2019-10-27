package com.nt.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.service.WishService;

public class WishController extends AbstractController {
	private WishService service;

	public WishController(WishService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		String msg=null;
		ModelAndView mav=null;
		//use service
		msg=service.generate();
		//create MAV object
		mav=new ModelAndView();
		mav.addObject("msg",msg);
		mav.addObject("sysDate", new Date());
		mav.setViewName("result");
		
		return mav;
	}//method
}//class
