package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.CustomerCommand;
import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerInfoMgmtService;

public class UpdateCustomerController extends SimpleFormController {
	private CustomerInfoMgmtService service;
	
	public UpdateCustomerController(CustomerInfoMgmtService service) {
		this.service = service;
	}

	@Override
	public Object formBackingObject(HttpServletRequest request) throws Exception {
		System.out.println("UpdateCustomerController.formBackingObject()");
	    int cno=0;
	    CustomerDTO dto=null;
	    CustomerCommand cmd=null;
		//read customer number from hyperlink
	    cno=Integer.parseInt(request.getParameter("cno"));
	    //use service
	    dto=service.fetchCustomerByCno(cno);
	    //create and Command class obj having dynamic initial values
	    cmd=new CustomerCommand();
	    BeanUtils.copyProperties(dto, cmd);
	    return cmd;
		
	}
	
	@Override
	public ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse res, Object command,
			BindException errors) throws Exception {
		CustomerCommand cmd=null;
		CustomerDTO dto=null;
		String resultMsg=null;
		List<CustomerDTO> listDTO=null;
		ModelAndView mav=null;
		//type casting
		cmd=(CustomerCommand)command;
		//Convert Command class obj to DTO class obj
		dto=new CustomerDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use service
		resultMsg=service.modifyCustomerByNo(dto);
		listDTO=service.fetchAllCustomers();
		//create and return MAV obj
		mav=new ModelAndView();
		mav.addObject("listDTO",listDTO);
		mav.addObject("resMsg",resultMsg);
		mav.setViewName("list_customers");
		return mav;
	}//method
	
	@Override
	public ModelAndView handleInvalidSubmit(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new  ModelAndView("dbl_post");
	}
}//class
