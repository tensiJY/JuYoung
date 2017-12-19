package com.juyoung.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.juyoung.domain.UserVO;
import com.juyoung.service.UserService;
import com.juyoung.util.SessionUtil;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	@Inject
	private UserService us;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean check = SessionUtil.isLogin(request.getSession(), "USER");
		
		if(check == false){
			
			getUri(request);
			
			
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			
			if(loginCookie!= null){
				System.out.println("11");
				UserVO userVO = us.checkUserWithSessionKey(loginCookie.getValue());
				
				if(userVO !=null){
					request.getSession().setAttribute("USER", userVO);
					return true;
				}
				
			}
			
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
