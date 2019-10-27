package com.nt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.nt.command.RegisterCommand;

public class RegistrationController extends SimpleFormController {
	
	@Override
	public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		SimpleDateFormat sdf=null;
		System.out.println("RegistrationController.initBinder(-,-)");
		sdf=new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class,
				                                              new CustomDateEditor(sdf,true));
	}
	
	@Override
	public ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse res, Object command,
			BindException errors) throws Exception {
		RegisterCommand cmd=null;
		//type casting
		cmd=(RegisterCommand)command;
		//create and  return MAV object
		return new ModelAndView("register","regCmd", cmd);
	}

}
