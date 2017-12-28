package com.juyoung.controller;


import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.juyoung.domain.ReportVO;
import com.juyoung.service.ReportService;
import com.juyoung.util.PageUtil;
import com.juyoung.validator.ReportValidator;
/**
 * 보고서 컨트롤러
 * @author  : 박주영 
 * @since   : 2017. 12. 28.
 * @version : 1.0
 * @see 
 *  == 개정이력(Modification Information) ==
 *   
 *  수정일             		   수정자   		  수정내용
 *  -------   		 --------    ---------------------------
 *  2017. 12. 28.	  			  최초생성			
 * 
 *
 */
@Controller
@RequestMapping(value="/Report")
public class ReportController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(ReportController.class); 
	
	@Inject
	private ReportService rs;
	
	@RequestMapping(value="/List", method=RequestMethod.GET)
	public void reportList(
			@RequestParam(value="nowPage", defaultValue="1") int nowPage ,
			Model model
			) throws Exception{
		
		
		int totalCount = rs.getTotalCount();
		
		if(totalCount == 0){
			return;
		}else{
			PageUtil pInfo = new PageUtil(nowPage, totalCount, 10);
			List<ReportVO> list = rs.getReportList(pInfo);
			model.addAttribute("ReportVO", list);
			model.addAttribute("nowPage",nowPage);
			model.addAttribute("PINFO", pInfo);
		}
	
	}
	
	@RequestMapping(value="/Form", method=RequestMethod.GET)
	public void reportForm() throws Exception{
		logger.info("	Form!!	");
	}
	
	@RequestMapping(value="/ReportProc")
	public String reportProc(@ModelAttribute("rvo")ReportVO rvo, 
			BindingResult result,
			RedirectAttributes rttr)throws Exception{
		logger.info("	proc!!");
		
		new ReportValidator().validate(rvo, result);
		
		if(result.hasErrors()){
			
			List<ObjectError> errList = result.getAllErrors();
			for(ObjectError e : errList){
				logger.info(e.getCode() + " " + e.getDefaultMessage());
			}
			
			return "Report/Form"; 
			
		}else{
			rs.writeReportProc(rvo);
			rttr.addFlashAttribute("MSG", "보고서 작성에 성공하였습니다.");
			return "redirect:../Report/List.park";
		}
		
		
	}// reportProc method end
	
	@RequestMapping(value="/View")
	public void reportView(@RequestParam Map<String, Object> map,
			Model model)throws Exception{
		String rno = map.get("rno").toString();
		
		model.addAttribute("nowPage", map.get("nowPage"));
		model.addAttribute("ReportVO", rs.getReportView(Integer.parseInt(rno)));
	}
	
	@RequestMapping(value="/ReportPrint", method=RequestMethod.GET)
	public String reportPrint(
			@RequestParam Map<String, Object> map, 
			RedirectAttributes rttr)throws Exception{
		
		String rno = map.get("rno").toString();
		rs.reportPrint(rno);
		
		rttr.addAttribute("nowPage", map.get("nowPage"));
		rttr.addAttribute("rno", rno);
		return "redirect:../Report/View.park";
	}
	
}// reportController end
