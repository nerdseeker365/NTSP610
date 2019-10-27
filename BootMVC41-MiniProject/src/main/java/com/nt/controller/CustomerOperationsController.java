package com.nt.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nt.command.CustomerCommand;
import com.nt.dto.CustomerDTO;
import com.nt.service.CustomerInfoMgmtService;

@Controller
public class CustomerOperationsController {
	@Resource
	private CustomerInfoMgmtService service;

	// handler method for launching home page
	@RequestMapping("/welcome.htm")
	public String showHome() {
		return "home";
	}

	@RequestMapping("/all_customers.htm")
	public String getAllCustomers(Map<String, Object> map) {
		List<CustomerDTO> listDTO = null;
		// use Service
		listDTO = service.fetchAllCustomers();
		// keep results map object
		map.put("listDTO", listDTO);
		// return lvn
		return "list_customers";
	}// method

	@RequestMapping(value = "/delete_customer.htm")
	public String deleteCustomer(HttpServletRequest req, Map<String, Object> map) {
		int cno = 0;
		String resMsg = null;
		List<CustomerDTO> listDTO = null;
		// read additonal req param values
		cno = Integer.parseInt(req.getParameter("cno"));
		// use Service class
		resMsg = service.removeCustomerByNo(cno);
		listDTO = service.fetchAllCustomers();
		// keep results in Map (model)
		map.put("listDTO", listDTO);
		map.put("resMsg", resMsg);
		// return logical View name
		return "list_customers";
	}// method

	// for InitialPahse request and formBackingObject(-,-)
	@RequestMapping(value = "/update_customer.htm", method = RequestMethod.GET)
	public String showUpdateForm(HttpServletRequest req, Map<String, Object> map) {
		int cno = 0;
		CustomerDTO dto = null;
		CustomerCommand cmd = null;
		// read customer number from hyperlink
		cno = Integer.parseInt(req.getParameter("cno"));
		// use service
		dto = service.fetchCustomerByCno(cno);
		// create and Command class obj having dynamic initial values
		cmd = new CustomerCommand();
		BeanUtils.copyProperties(dto, cmd);
		// keep Command class obj as model attribute
		map.put("custCmd", cmd);
		// return form page as lvn
		return "update_customer";

	}

	// for Postback request
	@RequestMapping(value = "/update_customer.htm", method = RequestMethod.POST)
	public String updateCustomer(Map<String, Object> map, @ModelAttribute("custCmd") CustomerCommand cmd,
			BindingResult errors) {
		CustomerDTO dto = null;
		String resultMsg = null;
		List<CustomerDTO> listDTO = null;
		ModelAndView mav = null;
		// Convert Command class obj to DTO class obj
		dto = new CustomerDTO();
		BeanUtils.copyProperties(cmd, dto);
		// use service
		resultMsg = service.modifyCustomerByNo(dto);
		listDTO = service.fetchAllCustomers();
		// create and return MAV obj

		map.put("listDTO", listDTO);
		map.put("resMsg", resultMsg);
		return "list_customers";
	}// method

}// class
