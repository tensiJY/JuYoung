package com.juyoung.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.juyoung.util.SessionUtil;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean check = SessionUtil.isLogin(request.getSession(), "USER");
		
		if(check == false){
			
			getUri(request);
			
			response.sendRedirect("../User/LoginForm.park");
			return false;
		}
		
		return true;
	}
	
	private void getUri(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String query = request.getQueryString();
		
		/*int len = uri.indexOf("k");
		uri = uri.substring(len+1);		
		uri = ".."+uri+"?"+query;*/
		
		uri = "../.."+uri;
		
		if(query!= null){
			uri = uri + "?"+query;
		}
		
		System.out.println(uri);
		request.getSession().setAttribute("URI", uri);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		super.postHandle(request, response, handler, modelAndView);
	}
}
