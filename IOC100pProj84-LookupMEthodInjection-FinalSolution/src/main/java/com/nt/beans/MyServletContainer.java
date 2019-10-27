package com.nt.beans;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component("container")
public abstract   class MyServletContainer  {
	
	public MyServletContainer() {
		System.out.println("MyServletContainer:: 0-param constructor");
	}
	
	@Lookup
	public abstract  RequestHandler createRequestHandler();
	
	public  void processRequest(String data) {
		RequestHandler handler=null;
		//perform TDL
		handler=createRequestHandler();
		//use RequestHadler
		System.out.println("request came for processing");
		handler.handleRequest(data);
		System.out.println("Request is processed");
	}
}
