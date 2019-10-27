package com.nt.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMvcAppConfig;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext ctx) throws ServletException {
		AnnotationConfigWebApplicationContext parentCtx=null,childCtx=null;
		ContextLoaderListener listener=null;
		DispatcherServlet servlet=null;
		ServletRegistration.Dynamic reg=null;
		//create Both Containers
		parentCtx=new AnnotationConfigWebApplicationContext();
		parentCtx.register(RootAppConfig.class);
		childCtx=new AnnotationConfigWebApplicationContext();
		childCtx.register(WebMvcAppConfig.class);
		//register ContextLoader Listener
		listener=new ContextLoaderListener(parentCtx);
		ctx.addListener(listener);
		//register DispatcherServlet 
		servlet=new DispatcherServlet(childCtx);
		reg=ctx.addServlet("ds",servlet);
		reg.addMapping("*.htm");
		reg.setLoadOnStartup(2);
	}
}
