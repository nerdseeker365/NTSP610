package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.CBuzzFindScoreService;

public class MainControllerServlet extends HttpServlet {
	private ApplicationContext ctx;
	private CBuzzFindScoreService service;
	@Override
	public void init() throws ServletException {
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get LocalService class obj
		service=ctx.getBean("cbService",CBuzzFindScoreService.class);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String score=null;
		int mid=0;
		RequestDispatcher rd=null;
		//read req paramer (mid)
		mid=Integer.parseInt(req.getParameter("mid"));
		//use Service
		score=service.findScore(mid);
		//keep score(result) is request scope
		req.setAttribute("result",score);
		//forward request show_result.jsp
		rd=req.getRequestDispatcher("/show_result.jsp");
		rd.forward(req, res);
		
		
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
