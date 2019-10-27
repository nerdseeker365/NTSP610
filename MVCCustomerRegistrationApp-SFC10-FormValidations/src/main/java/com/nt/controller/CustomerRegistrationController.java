package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.CustomerCommand;
import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerService;

public class CustomerRegistrationController extends SimpleFormController {
    private  CustomerService service;
    
	public CustomerRegistrationController(CustomerService service) {
		this.service = service;
	}

	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		CustomerCommand cmd=null;
		CustomerDTO dto=null;
		String resultMsg=null;
		//type casting of Command class
		cmd=(CustomerCommand)command;
		//Application logic errors
		if(cmd.getCadd().equalsIgnoreCase("hyderabaad")) {
			errors.rejectValue("cadd","customer.addrs.restriction");
			return  showForm(request, response,errors);
		}
			
		//Convert Command class obj to DTO class obj
		dto=new CustomerDTO();
		BeanUtils.copyProperties(cmd,dto);
		//use service class
		resultMsg=service.register(dto);
		//create and return MAV
		return new ModelAndView(getSuccessView(),"resultMsg",resultMsg);
	}//method
	
	@Override
	public ModelAndView handleInvalidSubmit(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		System.out.println("CustomerRegistrationController:handleInvalidSubmit(-,-)");
		return new ModelAndView("dbl_post");
	}
	
	@Override
	public Object formBackingObject(HttpServletRequest request) throws Exception {
	    System.out.println("CustomerRegistrationController:formBackingObject(-)");
	    CustomerCommand cmd=null;
	    cmd=new CustomerCommand();
	    cmd.setCadd("vizag");
	    cmd.setBillAmt((float)Math.random()*1000.0f);
	    return cmd;
	}
	
	
}
