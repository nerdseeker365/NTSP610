package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nt.command.EmployeeCommand;
import com.nt.dto.EmployeeDTO;
import com.nt.dto.EmployeeResultDTO;
import com.nt.service.EmployeeService;

@Controller
public class EmployeeSearchController  {
   @Autowired
	private  EmployeeService  service;


     @RequestMapping("/welcome.htm")
      public   String showHome() {
    	  return "search";
      }

    @RequestMapping("/search.htm")
	public String search(Map<String,Object> map,
			                             @ModelAttribute("empCmd")EmployeeCommand cmd) throws Exception {
		ModelAndView mav=null;
		EmployeeDTO  dto=null;
		List<EmployeeResultDTO> listRDTO=null;
		//convert Command class to DTO class
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use service class
		listRDTO=service.searchByInputs(dto);
		//create and return MAV
		map.put("listRDTO",listRDTO);
		return "list_emps";
	}

}
