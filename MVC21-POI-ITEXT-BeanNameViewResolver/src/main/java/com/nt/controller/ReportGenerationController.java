package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.EmployeeDTO;

public class ReportGenerationController extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		List<EmployeeDTO> listDTO=null;
		EmployeeDTO emp1=null,emp2=null;
		ModelAndView mav=null;
		//use service
		listDTO=new ArrayList();
		emp1=new EmployeeDTO();
		emp1.setEno(1001); emp1.setEname("raja");
		emp1.setDesg("CLERK"); emp1.setSalary(9000); emp1.setAddrs("hyd");
		emp2=new EmployeeDTO();
		emp2.setEno(1002); emp2.setEname("rajesh");
		emp2.setDesg("MANAGER"); emp2.setSalary(8000); emp2.setAddrs("vizag");
		listDTO.add(emp1);
		listDTO.add(emp2);
		//create and return MAV
		mav=new ModelAndView();
		mav.addObject("listDTO",listDTO);
		if(req.getParameter("type").equalsIgnoreCase("excel"))
			mav.setViewName("xlsView");
		else  if(req.getParameter("type").equalsIgnoreCase("pdf"))
			mav.setViewName("pdfView");
		
		return mav;
	}

}
