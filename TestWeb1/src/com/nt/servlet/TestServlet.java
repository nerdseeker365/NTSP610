package com.nt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test1")
public class TestServlet extends HttpServlet  implements SingleThreadModel{
	public TestServlet() {
		System.out.println("TestServlet:0-param constructor");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 try {
		 Thread.sleep(30000);
	 }
	 catch(InterruptedException ie) {
		 ie.printStackTrace();
	 }
	 System.out.println("from doGet(-,-)");
	 System.out.println("current obj hashCode::"+this.hashCode());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
