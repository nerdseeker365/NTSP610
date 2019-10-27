package com.nt.interceptor;

import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DoublePostingPreventorInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		HttpSession ses=null;
		String method=null;
		int cTkn=0,sTkn=0;
		RequestDispatcher rd=null;
		boolean flag=false;
		//get Session 
		ses=req.getSession();
		//for  form lauching (generate tokens)
		method=req.getMethod();
		if(method.equalsIgnoreCase("GET")) {
			//generate random number as   server side token and make it session token
			ses.setAttribute("sToken",new Random().nextInt(10000));
			flag=true;
		}
		else if(method.equalsIgnoreCase("POST")) {
			//match client and server side tokens
			cTkn=Integer.parseInt(req.getParameter("cToken"));
			sTkn=(int) ses.getAttribute("sToken");
			if(cTkn==sTkn){
				ses.setAttribute("sToken",new Random().nextInt(10000));
				flag=true;
			}
			else {
				//forward to error page
				rd=req.getRequestDispatcher("/dbl_post.jsp");
				rd.forward(req,res);
				flag=false;
			}
		}//else if
           return flag;
	}//preHandle(-,-,-)

}//class
