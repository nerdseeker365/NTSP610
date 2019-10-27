package com.nt.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.handler.CountriesHandler;
import com.nt.handler.Handler;
import com.nt.handler.LanguagesHandler;

public class LocaleFrontControllerServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String path=null;
        Handler handler=null;
        String lvn=null;
        String target=null;
        RequestDispatcher rd=null;
		//get Virtual path of request /servlet path
        path=req.getServletPath();
        try {
        //perform Navigation management
        if(path.equalsIgnoreCase("/lang.do")) {
        	handler=new LanguagesHandler();
        	lvn=handler.execute(req, res);
        }
        else if(path.equalsIgnoreCase("/country.do")) {
        	handler=new CountriesHandler();
        	lvn=handler.execute(req, res);
        }
        else {
        	throw new IllegalArgumentException();
        }
        }//try
        catch(Exception e) {
        	e.printStackTrace();
        	return;
        }
          //perform View Management
         if(lvn.equalsIgnoreCase("lang")) {
        	 target="/show_languages.jsp";
         }
         else if(lvn.equalsIgnoreCase("countries")) {
        	 target="/show_countries.jsp";
         }
         else {
        	 throw new IllegalArgumentException();
         }
         //froward request to dest page
         rd=req.getRequestDispatcher(target);
         rd.forward(req,res);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
