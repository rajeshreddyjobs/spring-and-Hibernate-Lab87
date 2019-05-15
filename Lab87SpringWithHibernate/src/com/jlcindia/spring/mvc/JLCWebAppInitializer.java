package com.jlcindia.spring.mvc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public  class JLCWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	@Override
	protected Class<?>[] getRootConfigClasses(){
		return new Class[] {JLCConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] { JLCConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"*.jlc"};
	}

}
