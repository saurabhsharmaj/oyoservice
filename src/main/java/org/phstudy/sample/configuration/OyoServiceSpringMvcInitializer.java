package org.phstudy.sample.configuration;

import java.io.File;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class OyoServiceSpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
    	new File(OyoServiceConstant.TEMP_DIR).mkdirs();
        return new Class[] { OyoServiceConfiguration.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    
    @Override
	protected Filter[] getServletFilters() {
		Filter []singleton =  new Filter[]{};
		return singleton;
	}
    
    @Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		registration.setMultipartConfig(getMultipartConfigElement());
	}
    
    private MultipartConfigElement getMultipartConfigElement() {
        MultipartConfigElement multipartConfigElement = new MultipartConfigElement( LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
        return multipartConfigElement;
    }
 
    private static final String LOCATION = OyoServiceConstant.TEMP_DIR; // Temporary location where files will be stored
 
    private static final long MAX_FILE_SIZE = 5242880; // 5MB : Max file size.
                                                        // Beyond that size spring will throw exception.
    private static final long MAX_REQUEST_SIZE = 20971520; // 20MB : Total request size containing Multi part.
     
    private static final int FILE_SIZE_THRESHOLD = 0; // Size threshold after which files will be written to disk
 
}