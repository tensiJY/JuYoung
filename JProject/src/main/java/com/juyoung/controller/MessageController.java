package com.juyoung.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.juyoung.domain.MessageVO;
import com.juyoung.service.MessageService;
import com.juyoung.util.SessionUtil;

@Controller
@RequestMapping(value="/Message")
public class MessageController {
	
	@Inject
	private MessageService ms;
	
	
	
	@RequestMapping(value="/MessageList")
	public void messageList(HttpSession session, Model model)throws Exception{
		String mid = SessionUtil.getId(session, "USER");
		model.addAttribute("MessageVO", ms.list(mid));
	}
	
	/**
	 * 
	 * @param meno
	 * @param session
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value="/MessageView", method=RequestMethod.GET)
	public void messageView(@RequestParam("meno") int meno, HttpSession session, Model model) throws Exception{
		String mid = SessionUtil.getId(session, "USER");
		
		model.addAttribute("MessageVO", ms.readMessage(meno, mid));
	}
	
	/**
	 * 
	 * @param mvo
	 * @param session
	 * @param rttr
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value="/AddMessage", method=RequestMethod.POST)
	public String addMessage(@ModelAttribute("mvo")  MessageVO mvo, 
			HttpSession session, 
			RedirectAttributes rttr)throws Exception{
		
		
		
			String mid = SessionUtil.getId(session, "USER");
			
			mvo.setMesender(mid);
			
			ms.create(mvo);
			rttr.addFlashAttribute("MSG", "메시지를 전송하였습니다");
			return "redirect:../Message/MessageList.park";
		
	}// method end
	
}// class end

