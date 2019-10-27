package com.nt.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCAppConfig;

public class MyWebApplicationInitializer implements WebApplicationInitializer {
	

	@Override
	public void onStartup(ServletContext ctx) throws ServletException {
		AnnotationConfigWebApplicationContext  rootCtx=null,childCtx=null;
		ContextLoaderListener listener=null;
		DispatcherServlet  servlet=null;
		ServletRegistration.Dynamic register=null;
		
		System.out.println("MyWebApplicationInitializer.onStartup()");
		//create both parent ,child COntainer
		rootCtx=new AnnotationConfigWebApplicationContext();
		rootCtx.register(RootAppConfig.class);
		childCtx=new AnnotationConfigWebApplicationContext();
		childCtx.register(WebMVCAppConfig.class);
		//create ContextLoaderListener and register 
		listener=new ContextLoaderListener(rootCtx);
		ctx.addListener(listener);
		//Register DispatcherServlet
		servlet=new DispatcherServlet(childCtx);
		register=ctx.addServlet("ds",servlet);
		register.addMapping("*.htm");
		register.setLoadOnStartup(2);
	}
}
