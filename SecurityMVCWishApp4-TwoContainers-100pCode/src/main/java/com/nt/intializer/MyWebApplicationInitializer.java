package com.nt.intializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.nt.config.RootAppConfig;
import com.nt.config.WebMVCAppConfig;

public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public Class<?>[] getRootConfigClasses() {
		
		return new Class[] {RootAppConfig.class};
	}

	@Override
	public Class<?>[] getServletConfigClasses() {
		return new Class[] {WebMVCAppConfig.class};
	}

	@Override
	public String[] getServletMappings() {
		return new String[] {"*.htm"};
	}

}
