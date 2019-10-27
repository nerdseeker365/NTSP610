package com.nt.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.DeptService;

public class MainControllerServlet extends HttpServlet {
	 ApplicationContext ctx=null;
	 DeptService  service=null;
	@Override
	public void init() throws ServletException {
		//create IOC Contianer
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean clss object
		service=ctx.getBean("deptService",DeptService.class);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String locs[]=null;
		List<Map<String,Object>> list=null;
		RequestDispatcher rd=null;
		//read form data
		locs=req.getParameterValues("loc");
		//use service
		list=service.findDeptsByLocations(locs);
		//keep data in request attribute
		req.setAttribute("deptLocs",list);
		//forward request to  jsp page
		rd=req.getRequestDispatcher("/display_result.jsp");
		rd.forward(req,res);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
	
	@Override
	public void destroy() {
	    service=null;
	    ((AbstractApplicationContext) ctx).close();
	}

}
