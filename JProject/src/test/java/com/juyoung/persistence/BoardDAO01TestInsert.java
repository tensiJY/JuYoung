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
public class BoardDAO01TestInsert {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(BoardDAO01TestInsert.class);
	
	@Inject
	private BoardDAO bdao;
	
	@Test
	public void testInsert()throws Exception{
		logger.info("	insertTest	");
		for(int i=0; i<1500; i++){
		BoardVO bvo = new BoardVO();
		bvo.setBtitle("제목"+i);
		bvo.setBcontent("내용"+i);
		bvo.setBwriter("pavvv");
		bdao.insert(bvo);}
	}
	
	
	
}
