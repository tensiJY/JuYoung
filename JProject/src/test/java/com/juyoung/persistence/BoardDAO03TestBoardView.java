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
public class BoardDAO03TestBoardView {
	
	private final Logger logger = 
			LoggerFactory.getLogger(BoardDAO03TestBoardView.class);
	
	@Inject
	private BoardDAO bdao;
	
	@Test
	public void testBoardView()throws Exception{
		BoardVO bvo = bdao.boardView(2);
		
		logger.info(" result : " + bvo.getBno() + " " + bvo.getBcontent() + " " + bvo.getBwriter() ); 
	}
	
}
