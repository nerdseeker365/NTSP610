package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.WishService;

@Controller
public class WishController {
	@Autowired
	private WishService service;
	
	
	@RequestMapping("/welcome.htm")
	public   String  showHome() {
		return  "home";
	}
	
	@RequestMapping("/wish.htm")
	public String  generateMsg(Map<String,Object>map) {
		String msg=null;
		//use service
		msg=service.generate();
		//keep result in model attribute
		map.put("wMsg",msg);
		return "result";
	}
	
	

}
