package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.nt.command.EmployeeCommand;
import com.nt.dto.EmployeeDTO;
import com.nt.dto.EmployeeResultDTO;
import com.nt.service.EmployeeService;

public class EmployeeSearchController extends AbstractCommandController {
	private  EmployeeService  service;

	public EmployeeSearchController(EmployeeService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		ModelAndView mav=null;
		EmployeeCommand cmd=null;
		EmployeeDTO  dto=null;
		List<EmployeeResultDTO> listRDTO=null;
		//typecasting on Command class
		cmd=(EmployeeCommand)command;
		//convert Command class to DTO class
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use service class
		listRDTO=service.searchByInputs(dto);
		//create and return MAV
		mav=new ModelAndView();
		mav.addObject("listRDTO",listRDTO);
		mav.setViewName("list_emps");
		return mav;
	}

}
