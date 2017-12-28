package com.juyoung.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.juyoung.domain.ReportVO;
import com.juyoung.persistence.ReportDAO;

@Service
public class ReportServiceImpl implements ReportService{
	
	@Inject
	private ReportDAO rdao;
	
	@Override
	public List<ReportVO> getReportList() throws Exception {
		return rdao.getReportList();
	}
	
	@Override
	public void writeReportProc(ReportVO rvo) throws Exception {
		/*		
		String rtimea = rvo.getRtimea();
		String rtimeb = rvo.getRtimeb();
		String rtimec = rvo.getRtimec();
		String rtimed = rvo.getRtimed();
		String rtimee = rvo.getRtimee();
		String rtimef = rvo.getRtimef();
		
		if(rtimea != null){
			String temp = rvo.getRtime1();
			temp = temp+ "##"+ rtimea;
			rvo.setRtime1(temp);
		}
		
		
		if(rtimeb != null){
			String temp = rvo.getRtime2();
			temp = temp+ "##"+ rtimeb;
			rvo.setRtime2(temp);
		}
		
		if(rtimec != null){
			String temp = rvo.getRtime3();
			temp = temp+ "##"+ rtimec;
			rvo.setRtime3(temp);
		}
		
		if(rtimed != null){
			String temp = rvo.getRtime4();
			temp = temp+ "#$%^"+ rtimed;
			rvo.setRtime4(temp);
		}
		
		if(rtimee != null){
			String temp = rvo.getRtime5();
			temp = temp+ "#$%^"+ rtimee;
			rvo.setRtime5(temp);
		}
		
		if(rtimef != null){
			String temp = rvo.getRtime6();
			temp = temp+ "#$%^"+ rtimef;
			rvo.setRtime6(temp);
		}*/
		
		rdao.writeReportProc(rvo);
	}// method writeReportProc end
}
