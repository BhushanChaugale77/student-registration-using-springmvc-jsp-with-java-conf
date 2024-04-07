package com.prowings.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
 		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
 		return null;
	}

	@Override
	protected String[] getServletMappings() {
 		return null;
	}

}
