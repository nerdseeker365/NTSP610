package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TilesController {

	@RequestMapping(value="/tech.htm")
	public String showTech() {
		
		return "techdef";
	}
	
}
