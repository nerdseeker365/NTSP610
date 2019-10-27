package com.nt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class RegistrationController extends SimpleFormController {
	
	@Override
	public Map<String,List<String>> referenceData(HttpServletRequest req) throws Exception {
		System.out.println("RegistrationController.referenceData(-)");
		Map<String,List<String>> refMap=null;
		List<String> countries=null;
		List<String> genders=null;
		List<String> hobies=null;
		List<String> courses=null;
		
		refMap=new HashMap();
		countries=new ArrayList();
		countries.add("---select---");
		countries.add("india"); countries.add("pakistan");
		countries.add("china"); countries.add("japan");
		refMap.put("countriesList",countries);
		
		genders=new ArrayList();
		genders.add("male"); genders.add("female");
		refMap.put("gendersList",genders);
		
		hobies=new ArrayList();
		hobies.add("Sleeping"); hobies.add("eating");
		hobies.add("Gossiping"); hobies.add("traveling");
		refMap.put("hobiesList",hobies);
		
		courses=new ArrayList();
		courses.add("Core JAva"); courses.add("Adv.java");
		courses.add("Servlet"); courses.add("Jsp");
		courses.add("Hibernate"); courses.add("Spring");
		refMap.put("coursesList", courses);
		
		return refMap;
	}
	
	@Override
	public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		return new ModelAndView("result","cmdData",command);
	}

}
