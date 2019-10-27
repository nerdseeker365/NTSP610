package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerInfoMgmtService;

public class ListCustomersController extends AbstractController {
	private  CustomerInfoMgmtService service;

	public ListCustomersController(CustomerInfoMgmtService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		List<CustomerDTO> listDTO=null;
		//use Service
		listDTO=service.fetchAllCustomers();
		//create and return MAV obj
		return new ModelAndView("list_customers","listDTO",listDTO);
	}//method
}//class
