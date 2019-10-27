package com.nt.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.WishService;

@Controller
public class WishMessageGenerator {
	@Autowired
	private WishService service;

	
	@RequestMapping("/welcome.htm")
	public   String showHome() {
		return "welcome";
		
	}
	
	
	@RequestMapping("/wish.htm")
	public String handle(Map<String,Object> map) {
		String msg=null;
		//use service
		msg=service.generate();
		//create Model data
		map.put("msg",msg);
		map.put("sysDate", new Date());
		
		return "result";
	}//method
	
	
	@RequestMapping("/about_us.htm")
	public   String showAboutUsPage() {
		return "about_us";
	}
	
	@RequestMapping("/contact_us.htm")
	public   String showContactUsPage() {
		return "contact_us";
	}
	
}//class
