package com.nt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

@Controller
@SessionAttributes(value="userCmd",types=UserCommand.class)
public class LoginController {
	@Autowired
	private   LoginService service;
	
	@ModelAttribute("userCmd")
	public    UserCommand  createCommand() {
		return new UserCommand();
	}
	
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
			                                            @Valid @ModelAttribute("userCmd") UserCommand cmd,
			                                            BindingResult errors) {
		UserDTO  dto=null;
		String result=null;
		//Convert Command class obj to DTO class obj
		dto=new UserDTO();
		BeanUtils.copyProperties(cmd,dto);
		//use service class
		result=service.validate(dto);
		//keep the result in Model Attribute
		map.put("resultMsg",result);
		map.put("cmdData",cmd);
		return "login_form";
		
	}
	
	
	@ModelAttribute("countries")
	public   List<String>  populateCountries(){
		List<String> countriesList=null;
		countriesList=new ArrayList();
		countriesList.add("india");
		countriesList.add("srilanka");
		countriesList.add("USA");
		countriesList.add("China");
		return  countriesList;
	}
	
	@ModelAttribute("hobiesList")
	public   List<String>  poulateHobies(){
		List<String> hbList=null;
		hbList=new ArrayList();
		hbList.add("sleeping");
		hbList.add("eating");
		hbList.add("roaming");
		hbList.add("shopping");
		return  hbList;
	}
	
	
	

}
