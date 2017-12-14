package com.juyoung.persistence;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.juyoung.domain.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAO06TestMoidfyProc {
	
	private final Logger logger = LoggerFactory.getLogger(BoardDAO06TestMoidfyProc.class);
	
	@Inject
	private BoardDAO bdao;
	
	
	@Test
	public void testMoidfyProc()throws Exception{
		int bno = 2;
		BoardVO bvo = bdao.modifyForm(bno);
		logger.info(" bno : " + bno + " " + bvo.getBtitle() + " " + bvo.getBcontent());
		
		bvo.setBtitle("수정하는 제목1");
		bvo.setBcontent("수정하는 내용");
		
		bdao.modifyProc(bvo);
		
		
		BoardVO bvo2 = bdao.modifyForm(bno);
		logger.info(" bno : " + bno + " " + bvo2.getBtitle() + " " + bvo2.getBcontent());
		
	}
	
}
