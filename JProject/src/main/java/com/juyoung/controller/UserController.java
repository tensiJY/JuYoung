package com.juyoung.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import com.juyoung.domain.UserVO;
import com.juyoung.dto.LoginDTO;
import com.juyoung.service.UserService;
import com.juyoung.validator.UserValidator;

@Controller
@RequestMapping("/User")
public class UserController {
	
	@Inject
	private UserService us;
	
	@RequestMapping(value="/LoginForm")
	public String loginForm(){
		return "User/LoginForm";
	}
	
	@RequestMapping(value="/Logout")
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		
		UserVO uvo = (UserVO) session.getAttribute("USER");
		if(uvo != null){
			session.removeAttribute("USER");
			session.invalidate();
		}
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		
		if(loginCookie != null){
			loginCookie.setPath("/");
			loginCookie.setMaxAge(0);
			response.addCookie(loginCookie);
			us.keepLogin(uvo.getMid(), uvo.getMsession(), new Date());
		}
		return "redirect:../";
	}
	
	@RequestMapping(value="/LoginProc", method=RequestMethod.POST)
	public void loginProc(@ModelAttribute("ldto") LoginDTO ldto,
			HttpSession session, Model model) throws Exception{
		
		System.out.println(System.currentTimeMillis());
		
		if(session.getAttribute("USER") != null){
			session.removeAttribute("USER");
		}
		
		
		UserVO vo = us.login(ldto);
		
		if(vo != null){
			model.addAttribute("userVO", vo);
			
			if(ldto.isUseCookie()){
				System.out.println(ldto.isUseCookie());
				
				int amount = 60*60*24*7;
				Date sessionLimit = new Date(System.currentTimeMillis()+(1000*amount));
				
				us.keepLogin(vo.getMid(), session.getId(), sessionLimit);
			}
		}
		
	}// loginProc method end
	
	/**
	 * @valid를 사용하기위해선 빈 객체를 내려보내야 한다.
	 * form:form과 비교할 대상이 필요하다.
	 */
	@RequestMapping(value="/JoinForm")
	public void joinForm()throws Exception{}
	
	
	/*
	 * 
	 * XXXvalid라는 객체를 생성.
	 * interface Validator 를 구현
	 * supports 와 validate를 오버라이딩 한다.
	 * 
	 * 컨트롤러에서느 BindingResult result를 매개 변수를 한다.
	 * 제작한 발리데이터의 validate()함수에 바인딩한 객체와 result를 매개변수로 넘겨준다.
	 * 
	 */
	@RequestMapping(value="/JoinProc", method=RequestMethod.POST)
	public String joinProc(@ModelAttribute("uvo") UserVO uvo, BindingResult result){
		
		new UserValidator().validate(uvo, result);
		
		if(result.hasErrors()){
			result.getAllErrors();
			return "User/JoinForm";
		}else {
			return "User/JoinProc";
		}
		
	}// joinProc method end
}
