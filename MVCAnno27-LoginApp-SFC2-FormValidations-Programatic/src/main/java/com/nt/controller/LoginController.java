package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nt.command.UserCommand;
import com.nt.dto.UserDTO;
import com.nt.service.LoginService;
import com.nt.validator.LoginValidator;

@Controller
//@SessionAttributes(value="userCmd",types=UserCommand.class)
public class LoginController {
	@Autowired
	private   LoginService service;
	@Autowired
	private  LoginValidator  validator;
	
	//for  initial phase request
/*	@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public   String showForm(Map<String,Object> map) {
		UserCommand cmd=null;
		//create Command class object
		cmd=new UserCommand();
		cmd.setUser("raja");
		map.put("userCmd",cmd);
		return "login_form";
	} */
	
	@RequestMapping(value="/login.htm",method=RequestMethod.GET)
	public   String showForm(@ModelAttribute("userCmd") UserCommand cmd) {
		return "login_form";
	}
	
	//for postback requst
	@RequestMapping(value="/login.htm",method=RequestMethod.POST)
	public  String  processForm(Map<String,Object> map,
			                                            @ModelAttribute("userCmd") UserCommand cmd,
			                                            BindingResult errors) {
		UserDTO  dto=null;
		String result=null;
		//perform validations (server side)
		if(validator.supports(UserCommand.class)) {
			 validator.validate(cmd, errors);
			 if(errors.hasErrors())
				   return "login_form";
		}
		
		//application logic errors
		if(cmd.getUser().equalsIgnoreCase("raja")) {
			errors.rejectValue("user","user.blocked");
			return "login_form";
		}
		
		//Convert Command class obj to DTO class obj
		dto=new UserDTO();
		BeanUtils.copyProperties(cmd,dto);
		//use service class
		result=service.validate(dto);
		//keep the result in Model Attribute
		map.put("resultMsg",result);
		return "login_form";
		
	}
	
	
	

}
