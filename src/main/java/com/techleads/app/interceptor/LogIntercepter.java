package com.techleads.app.interceptor;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Component
public class LogIntercepter implements HandlerInterceptor {
	
	private static Logger logger=LoggerFactory.getLogger(LogIntercepter.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("inside preHandle()");
		//return HandlerInterceptor.super.preHandle(request, response, handler);
		request.setAttribute("startTime", System.currentTimeMillis());
		logger.info(request.getPathInfo());
		logger.info(request.getMethod());
		logger.info(String.valueOf(request.getRequestURL()));
		Iterator<String> itr = request.getHeaderNames().asIterator();
		while(itr.hasNext()) {
			String next = itr.next();
			logger.info(next);
			
		}
		
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		Long time = (Long)request.getAttribute("startTime");
		logger.info("inside postHandle(): the time taken for processing request: "+(System.currentTimeMillis()-time));
//		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("inside afterCompletion()");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
