package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerInfoMgmtService;

public class DeleteCustomerController extends AbstractController {
	private CustomerInfoMgmtService service;

	public DeleteCustomerController(CustomerInfoMgmtService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		int cno=0;
		String resMsg=null;
		ModelAndView mav=null;
		List<CustomerDTO> listDTO=null;
		//read additonal req param values
		cno=Integer.parseInt(req.getParameter("cno"));
		//use Service  class
		resMsg=service.removeCustomerByNo(cno);
		listDTO=service.fetchAllCustomers();
		//create and return MAV object 
		mav=new ModelAndView();
		mav.addObject("listDTO",listDTO);
		mav.addObject("resMsg",resMsg);
		mav.setViewName("list_customers");
		return mav;
	}
	
	

}
