package com.juyoung.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final String USER = "USER";
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		ModelMap modelMap = modelAndView.getModelMap();
		Object userVO = modelMap.get("userVO");
		
		
		
		if(userVO != null){
			
			Object URI = request.getSession().getAttribute("URI");
			
			if(URI == null){
				session.setAttribute(USER, userVO);
				modelAndView.addObject("URI", "../");
			}else{
				session.removeAttribute("URI");
				session.setAttribute(USER, userVO);
				modelAndView.addObject("URI", URI);
				
			}
			
			
		} else if (userVO == null){
			
			modelAndView.addObject("URI", "../User/LoginForm.park");
			
		}
		
	}
}
