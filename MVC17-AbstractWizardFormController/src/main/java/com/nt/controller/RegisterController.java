package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import com.nt.command.RegisterCommand;

public class RegisterController extends AbstractWizardFormController {

	@Override
	public ModelAndView processFinish(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		System.out.println("RegisterController.processFinish()");
		RegisterCommand cmd=null;
		//type casting
		cmd=(RegisterCommand)command;
		return new ModelAndView("result","cmdData", cmd);
	}
	
	
	
	@Override
	public ModelAndView processCancel(HttpServletRequest req, HttpServletResponse res, Object command,
			BindException errors) throws Exception {
		System.out.println("RegisterController.processCancel()");
		return  new ModelAndView("home");
		
	}

}
