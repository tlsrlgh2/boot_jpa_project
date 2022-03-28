package com.project.intercepter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class loggerintercepter implements HandlerInterceptor {

	// 호출되기전 pre
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		System.out.println("loginIntercepter pre"+request.getRequestURI());

	        HttpSession session = request.getSession();
	        String userid = (String)session.getAttribute("userid");
	        
	        if(userid != null) {
	            return true;
	        } else {
	              try { 
	            	  
	          			response.setContentType("text/html; charset=UTF-8");
	          			 
	          			PrintWriter out = response.getWriter();
	          			 
	          			out.println("<script> alert('로그인 후 이용 가능합니다'); location='/user/login'; </script>");
	          			 
	          			out.flush();
	          			
	              } catch (IOException e) {
	                  e.printStackTrace(); 
	              }
	            return false;
	        }
	}

	// 호출 된 후 실행.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("intercepter post");
	}

}
