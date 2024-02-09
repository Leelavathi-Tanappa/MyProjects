package com.org.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//Dispatcher Servlet
public class FrontControllerInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {HelloWorldAppConfig.class}; //Takes all other controllers
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/myapp.com/*"}; //Root url for this Dispatcher Servelt
	}
}
