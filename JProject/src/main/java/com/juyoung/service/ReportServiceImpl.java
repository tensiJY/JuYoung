package com.juyoung.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.juyoung.domain.ReportVO;
import com.juyoung.persistence.ReportDAO;
import com.juyoung.util.MsWordUtil;
import com.juyoung.util.PageUtil;
import com.juyoung.util.StringUtil;

@Service
public class ReportServiceImpl implements ReportService{
	
	@Inject
	private ReportDAO rdao;
	
	@Override
	public int getTotalCount() throws Exception {
		// TODO Auto-generated method stub
		return rdao.getTotalCount();
	}
	
	@Override
	public List<ReportVO> getReportList(PageUtil pInfo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("START", pInfo.getStart());
		map.put("END", pInfo.getEnd());
		return rdao.getReportList(map);
	}
	
	@Override
	public void writeReportProc(ReportVO rvo) throws Exception {
			
		String rtimea = rvo.getRtimea();
		String rtimeb = rvo.getRtimeb();
		String rtimec = rvo.getRtimec();
		String rtimed = rvo.getRtimed();
		String rtimee = rvo.getRtimee();
		String rtimef = rvo.getRtimef();
		
		if(rtimea != null || rtimea.trim().length()!=0){
			String temp = rvo.getRtime1();
			temp = temp+ "##"+ rtimea;
			rvo.setRtime1(temp);
		}
		
		
		if(rtimeb != null || rtimeb.trim().length()!=0){
			String temp = rvo.getRtime2();
			temp = temp+ "##"+ rtimeb;
			rvo.setRtime2(temp);
		}
		
		if(rtimec != null || rtimec.trim().length()!=0){
			String temp = rvo.getRtime3();
			temp = temp+ "##"+ rtimec;
			rvo.setRtime3(temp);
		}
		
		if(rtimed != null || rtimed.trim().length()!=0){
			String temp = rvo.getRtime4();
			temp = temp+ "##"+ rtimed;
			rvo.setRtime4(temp);
		}
		
		if(rtimee != null || rtimee.trim().length()!=0){
			String temp = rvo.getRtime5();
			temp = temp+ "##"+ rtimee;
			rvo.setRtime5(temp);
		}
		
		if(rtimef != null || rtimef.trim().length()!=0){
			String temp = rvo.getRtime6();
			temp = temp+ "##"+ rtimef;
			rvo.setRtime6(temp);
		}
		
		rdao.writeReportProc(rvo);
	}// method writeReportProc end
	
	@Override
	public ReportVO getReportView(int rno) throws Exception {
		ReportVO rvo = rdao.getReportView(rno);
		
		String[] rtimes = {	rvo.getRtime1(), rvo.getRtime2(), rvo.getRtime3(),
							rvo.getRtime4(),rvo.getRtime5(), rvo.getRtime6()	};
		
		for(int i=0; i<rtimes.length; i++){
			String temp = rtimes[i];
			int len = temp.indexOf("##");
			if(len != -1){
				String temp1 = StringUtil.sliceFirst(temp, "##");
				String temp2 = StringUtil.sliceSecond(temp, "##");
				
				switch(i) {
					case 0 :
						rvo.setRtime1(temp1);
						rvo.setRtimea(temp2);
						break;
						
					case 1 :
						rvo.setRtime2(temp1);
						rvo.setRtimeb(temp2);
						break;
						
					case 2 :
						rvo.setRtime3(temp1);
						rvo.setRtimec(temp2);
						break;
						
					case 3 : 
						rvo.setRtime4(temp1);
						rvo.setRtimed(temp2);
						break;
						
					case 4 : 
						rvo.setRtime5(temp1);
						rvo.setRtimee(temp2);
						break;
						
					case 5 :
						rvo.setRtime6(temp1);
						rvo.setRtimef(temp2);
						break;
				}// switch end;
			}// for end;
		}
		
		return rvo;
	}// method end
	
	@Override
	public void reportPrint(String rno) throws Exception {
		
		ReportVO rvo = this.getReportView(Integer.parseInt(rno));
		new MsWordUtil().makeMsWord(rvo);
		
	}
}
