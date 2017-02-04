package org.phstudy.sample.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class OyoServiceExceptionResolver extends SimpleMappingExceptionResolver implements HandlerExceptionResolver{
	private final Logger log = LoggerFactory.getLogger(OyoServiceExceptionResolver.class);
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ex.printStackTrace();
		String viewName=determineViewName(ex, request);
		log.debug(viewName+" :",ex);
		System.out.println("viewName:"+viewName);
		if (viewName!=null) {
			Integer statusCode = super.determineStatusCode(request, viewName);
			if (statusCode != null) {
				applyStatusCodeIfPossible(request, response, statusCode);
			}
			request.setAttribute("message", ex.getMessage());
			return getModelAndView(viewName, ex, request);
		}
		return getModelAndView(viewName, ex, request);

	}
	
	
	
}