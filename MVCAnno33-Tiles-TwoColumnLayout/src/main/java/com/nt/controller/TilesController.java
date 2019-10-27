package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TilesController {
	
	@RequestMapping("/welcome.htm")
	public  String showHomePage() {
		return "page1Def";
	}
	
	@RequestMapping("/sports.htm")
	public  String  showSportsPage() {
		return "page2Def";
	}
	@RequestMapping("/politics.htm")
	public  String  showPoliticsPage() {
		return "page3Def";
	}
	@RequestMapping("/entertainment.htm")
	public  String  showEntertaimentPage() {
		return "page4Def";
	}

}
