package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.command.UserCommand;
import com.nt.dto.UserDTO;
import com.nt.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private   LoginService service;

	@GetMapping("/login")
	public String  showForm(@ModelAttribute("userCmd")UserCommand cmd) {
		cmd.setUser("raja");
		return "login_form";
		
	}
	
	@PostMapping("/login")
	public  String   processForm(Map<String,Object> map,
			@ModelAttribute("userCmd")UserCommand cmd) {
		UserDTO dto=null;
		String resultMsg=null;
		//Convert cmd to DTO
		dto=new UserDTO();
		BeanUtils.copyProperties(cmd,dto);
		//use Service
		resultMsg=service.validate(dto);
		//put in Model Attribute
		map.put("resultMsg",resultMsg);
		return "login_form";
	}
			                               
	
}
