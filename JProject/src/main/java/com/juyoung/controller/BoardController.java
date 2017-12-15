package com.juyoung.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.juyoung.domain.BoardVO;
import com.juyoung.service.BoardService;
import com.juyoung.util.PageUtil;


/**
 * 
 * @author	박주영
 * @since	
 *
 */
@Controller
@RequestMapping(value="/Board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService bs;
	
	/**
	 * 게시판 리스트
	 * @param nowPage
	 * @param model
	 * @return 
	 * @throws Exception
	 */
	@RequestMapping(value="/BoardList", method=RequestMethod.GET)
	public String boardList(@RequestParam(value="nowPage", defaultValue="1") int nowPage,
			Model model) throws Exception{
		
		int totalCount = bs.count();
		if(totalCount == 0){
			return "Board/BoardList";
		}else{
			PageUtil pInfo = new PageUtil(nowPage, totalCount, 10);
			List<BoardVO> list = bs.boardList(pInfo);
			model.addAttribute("BLIST", list);
			model.addAttribute("PINFO", pInfo);
			return "Board/BoardList";
					
		}
		
	}
	
	/**
	 *  
	 * @return Board/boardWriteForm.jsp
	 */
	@RequestMapping(value="/BoardWriteForm", method=RequestMethod.GET)
	public String boardWriteForm(@RequestParam(value="nowPage")int nowPage, Model model){
		logger.info("	controller	Board/BoardWriteForm");
		model.addAttribute("nowPage", nowPage);
		return "Board/BoardWriteForm";
	}
	
	/**
	 * 
	 * @param bvo
	 * @param rttr
	 * @return redirect:../Board/BoardList.do
	 * @throws Exception
	 */
	@RequestMapping(value="/Insert", method=RequestMethod.POST)
	public String insert(BoardVO bvo, RedirectAttributes rttr) throws Exception{
		logger.info("	controller	Board/Insert");
		bs.insert(bvo);
		rttr.addAttribute("nowPage", bvo.getNowPage());
		rttr.addFlashAttribute("MSG", "SUCCESS1");
		return "redirect:../Board/BoardList.do";
	}
	
	/**
	 * 
	 * @param bno
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/BoardView", method=RequestMethod.GET)
	public String boardView(@RequestParam(value="bno") int bno,
			@RequestParam(value="nowPage", required=false) int nowPage,
			Model model)throws Exception{
		logger.info(" boardView : " + bno);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("BoardVO" , bs.boardView(bno));
		List<BoardVO> rvo = bs.replyList(bno);
		System.out.println(rvo.size());
		model.addAttribute("RLIST", rvo);
		return "Board/BoardView";
	}
	
	@RequestMapping(value="/Remove", method=RequestMethod.POST)
	public String remove(@RequestParam(value="bno") int bno, 
			@RequestParam(value="nowPage")int nowPage,
			RedirectAttributes rttr) throws Exception{
		logger.info("	Remove : " + bno);
		bs.remove(bno);
		rttr.addAttribute("nowPage", nowPage);
		rttr.addFlashAttribute("MSG", "SUCCESS2");
		return "redirect:../Board/BoardList.do";
	}
	
	@RequestMapping(value="/ModifyForm", method=RequestMethod.GET)
	public String modifyForm(@RequestParam(value="bno")int bno,
			@RequestParam(value="nowPage", required=false) int nowPage,
			Model model)
			throws Exception{
		BoardVO bvo = bs.modifyForm(bno);
		model.addAttribute("nowPage", nowPage);
		model.addAttribute("BoardVO", bvo);
		return "Board/BoardModifyForm";
	}
	
	@RequestMapping(value="/ModifyProc", method=RequestMethod.POST)
	public String modifyProc(BoardVO bvo, RedirectAttributes rttr)throws Exception{
		bs.modifyProc(bvo);
		rttr.addAttribute("nowPage", bvo.getNowPage());
		rttr.addFlashAttribute("MSG", "SUCCESS3");
		return "redirect:../Board/BoardList.do"; 
	}
	
	@RequestMapping(value="/SearchList")
	public String searchList(@ModelAttribute("bvo")BoardVO bvo,
							 @RequestParam(value="nowPage", defaultValue="1")int nowPage,
							Model model)throws Exception{
		
		String word = bvo.getWord();
		if(word== null){
			word = "ALL";
			bvo.setWord(word);
		}
				
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("SEARCH", bvo.getSearch());
		map.put("WORD", bvo.getWord());
		
		int totalCount = bs.searchCount(map);
		
		PageUtil pInfo = new PageUtil(nowPage, totalCount, 10);
		
		map.put("PINFO", pInfo);
		List<BoardVO> list = bs.searchList(map); 
		
		
		model.addAttribute("PINFO", pInfo);
		model.addAttribute("BoardVO", bvo);
		model.addAttribute("LIST", list);
		return "Board/SearchList";
	}
	
	@RequestMapping("/SearchView")
	public String searchView(@ModelAttribute("bvo")BoardVO bvo, Model model) throws Exception{
		String word = bvo.getWord();
		String search = bvo.getSearch();
		int nowPage = bvo.getNowPage();
		BoardVO svo = bs.searchView(bvo.getBno());
		
		svo.setWord(word);
		svo.setSearch(search);
		svo.setNowPage(nowPage);
		model.addAttribute("BoardVO", svo);		
		return "Board/SearchView";
	}
	
	
	@RequestMapping("/ReplyProc")
	public String replyProc(@ModelAttribute("bvo")BoardVO rvo, RedirectAttributes rttr)throws Exception{
		bs.replyProc(rvo);
		rttr.addFlashAttribute("MSG", "RSUCCESS1");
		rttr.addAttribute("nowPage", rvo.getNowPage());
		rttr.addAttribute("bno", rvo.getBno());
		return "redirect:../Board/BoardView.do";
	}
	
	@RequestMapping("/RemoveReply")
	public String removeReply(@ModelAttribute("bvo")BoardVO rvo, RedirectAttributes rttr)throws Exception{
		bs.removeReply(rvo.getRrno());
		rttr.addAttribute("nowPage", rvo.getNowPage());
		rttr.addAttribute("bno", rvo.getBno());
		rttr.addFlashAttribute("MSG", "RSUCCESS3");
		return "redirect:../Board/BoardView.do";
	}
	
	@RequestMapping("/ReplyModify")
	public String replyModify(@ModelAttribute("rvo")BoardVO rvo, RedirectAttributes rttr)throws Exception{
		bs.replyModify(rvo);
		rttr.addAttribute("nowPage", rvo.getNowPage());
		rttr.addAttribute("bno", rvo.getBno());
		rttr.addFlashAttribute("MSG", "RSUCCESS2");
		return "redirect:../Board/BoardView.do";
	}
	
	@RequestMapping("/Msearch")
	public String mSearch(@ModelAttribute("cvo")BoardVO cvo)throws Exception{
		List<BoardVO> cList = bs.mSearch(cvo);
		System.out.println(cList.size());
		return "";
	}
}
