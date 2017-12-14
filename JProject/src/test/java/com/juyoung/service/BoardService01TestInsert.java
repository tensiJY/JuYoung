package com.juyoung.service;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.juyoung.domain.BoardVO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
		"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardService01TestInsert {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(BoardService01TestInsert.class);
	
	@Inject
	private BoardService bs;
	
	@Test
	public void testInsert()throws Exception{
		logger.info("	service testInsert()");
		BoardVO bvo = new BoardVO();
		bvo.setBtitle("제목입니다");
		bvo.setBwriter("작성자01");
		bvo.setBcontent("내용입니다");
		bs.insert(bvo);
	}
	
	
}
