package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.service.WishService;

@Controller
public class WishController {
	@Autowired
	private WishService service;
	
	@GetMapping("/welcome.htm")
	public  String showHome() {
		return "home";
	}
	
	@GetMapping("/wish.htm")
	public   String  generateWish(Map<String,Object> map) {
		String msg=null;
		//use Service
		msg=service.generate();
		//put in model attrobute
		map.put("wMsg",msg);
		return "result";
	}

}
