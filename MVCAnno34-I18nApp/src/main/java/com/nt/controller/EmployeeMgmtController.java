package com.nt.controller;

import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.command.EmployeeCommand;

@Controller
public class EmployeeMgmtController {
	
	@RequestMapping("/register.htm")
	public  String   showHomePage(@ModelAttribute("empCmd")EmployeeCommand cmd,Map<String,Object> map) {
         map.put("sysDate",new Date())	;
         map.put("prizeMoney",new Random().nextInt(10000000));
		return "employee_register";
	}
	

}
