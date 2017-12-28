package com.juyoung.controller;


import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juyoung.domain.ReportVO;
import com.juyoung.service.ReportService;

@Controller
@RequestMapping(value="/Report")
public class ReportController {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(ReportController.class); 
	
	@Inject
	private ReportService rs;
	
	@RequestMapping(value="/List", method=RequestMethod.GET)
	public void reportList(Model model) throws Exception{
		List<ReportVO> list = rs.getReportList();
		model.addAttribute("ReportVO", list);
		logger.info("	list!!	" + list.size());
	}
	
	@RequestMapping(value="/Form", method=RequestMethod.GET)
	public void reportForm() throws Exception{
		logger.info("	Form!!	");
	}
	
	@RequestMapping(value="/ReportProc")
	public void reportProc(@ModelAttribute("rvo")ReportVO rvo )throws Exception{
		logger.info("	proc!!");
		System.out.println(rvo.getRdate());
		
		System.out.println(rvo.getRtitle() + " " + rvo.getRdname() + " " + rvo.getRdjob()+
				rvo.getRdate()+ " " + rvo.getRname()+ " " + rvo.getRtime1() + " " + rvo.getRtime2() +
				rvo.getRtime3() +" "+ rvo.getRtime4()+ " " + rvo.getRtime5() + 
				" " +  rvo.getRtime6() + rvo.getReduc() + " " +  
				rvo.getRtrou() + " " + rvo.getRprog() + rvo.getRsumm()
				);
		rs.writeReportProc(rvo);
		
	}
}
