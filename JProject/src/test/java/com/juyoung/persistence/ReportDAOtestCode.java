package com.juyoung.persistence;


import java.sql.Date;
import java.util.Random;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.juyoung.domain.ReportVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class ReportDAOtestCode {
	
	private static final Logger logger =
			LoggerFactory.getLogger(ReportDAOtestCode.class);
	
	private ReportVO rvo;
	
	@Inject
	private ReportDAO dao;
	
	
	@Test
	public void testWriteReportProc()throws Exception{
		int loop = 1000;
		
		String[] rdname = {"회계", "정보전략팀", "인사", "총무"};
		String[] rdjob = {"사원", "주임", "대리", "과장"};
		String[] rname = {"박주영", "주영", "김대오", "대오"};
		
		for(int i=0; i<loop ;i++){
			int ran = new Random().nextInt(4);
			rvo = new ReportVO();
			rvo.setRtitle("일일업무보고서");
			rvo.setRdname(rdname[ran]);
			rvo.setRdjob(rdjob[ran]);
			rvo.setRdate(new Date(System.currentTimeMillis()));
			rvo.setRname(rname[ran]);
			rvo.setRtime1("출근");
			rvo.setRtime2("UI계획");
			rvo.setRtime3("DB설계");
			rvo.setRtime4("점심");
			rvo.setRtime5("View설계");
			rvo.setRtime6("테스트 코드 작성");
			rvo.setReduc("asdfsss");
			rvo.setRprog("ssss");
			rvo.setRsumm("sss");
			rvo.setRtrou("eeee");
			dao.writeReportProc(rvo);
		}// for end
		
		logger.info("	success	: testWriteReportProc()");
	}// method testWriteReportProc end
	
}// class ReportDAOtestCode end
