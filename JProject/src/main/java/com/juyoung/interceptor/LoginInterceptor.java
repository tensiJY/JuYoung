package com.juyoung.interceptor;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import javax.servlet.http.Cookie;
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
			
			session.setAttribute(USER, userVO);
						
			// 자동 로그인을 체크 했을 경우 -> 쿠키 생성
			/*
			 * 자동 로그인 처리의 기본 아이디어는 세션+쿠키를 이용
			 * HttpSession에 USER 
			 */
			String coo = (String) request.getParameter("useCookie");
			
			if(coo != null){
				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				loginCookie.setPath("/");			 // path 모든 경로에서 접근 가능하도록..			
				loginCookie.setMaxAge(60*60*24*7);	 // 시간.
				response.addCookie(loginCookie);
			}
			
			
			Object URI = request.getSession().getAttribute("URI");
			session.removeAttribute("URI");
			
			modelAndView.addObject("URI", URI != null? URI : "../");
			
		} else if (userVO == null){
			
			modelAndView.addObject("URI", "../User/LoginForm.park");
			
		}
		
	}
}
