package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;


public class MainControllerServlet extends HttpServlet {
      private BankService proxy;
      ApplicationContext ctx=null;
	public void init() throws ServletException {
		System.out.println("MainControllerServlet.init()");
	   ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	   proxy=ctx.getBean("bankService",BankService.class);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		proxy=null;
		((AbstractApplicationContext) ctx).close();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher rd=null;
        int srcAcno=0,destAcno=0;
        float amt=0.0f;
        boolean status=false;
        //read form data
        srcAcno=Integer.parseInt(req.getParameter("srcAcno"));
        destAcno=Integer.parseInt(req.getParameter("destAcno"));
        amt=Float.parseFloat(req.getParameter("amount"));
        //invoke b.method
        try {
        	status=proxy.transferMoney(srcAcno, destAcno, amt);
        	req.setAttribute("status", status);
        	rd=req.getRequestDispatcher("result.jsp");
        	rd.forward(req,res);
        }
        catch(Exception e) {
        	req.setAttribute("status", "Internal Problem --Moneny not transfered");
        	rd=req.getRequestDispatcher("error.jsp");
        	rd.forward(req,res);
        }
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
