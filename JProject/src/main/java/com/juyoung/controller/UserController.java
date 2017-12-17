package com.juyoung.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juyoung.domain.UserVO;
import com.juyoung.dto.LoginDTO;
import com.juyoung.service.UserService;
import com.juyoung.util.SessionUtil;

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
	public String logout(HttpSession session){
		session.removeAttribute("USER");
		return "redirect:../";
	}
	
	@RequestMapping(value="/LoginProc", method=RequestMethod.POST)
	public void loginProc(@ModelAttribute("ldto") LoginDTO ldto, HttpSession session, Model model) throws Exception{
		UserVO vo = us.login(ldto);
		
		if(vo == null){
			
			
			
		}else{
			
			model.addAttribute("userVO", vo);
			
		}
	}
	
		
	
}
