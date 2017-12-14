package com.juyoung.service;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardService05TestRemoveBno {
	
	private final Logger logger = 
			LoggerFactory.getLogger(BoardService05TestRemoveBno.class);
	
	@Inject
	private BoardService bs;
	
	@Test
	public void testRemoveBno()throws Exception{
		int bno = 1;
		bs.remove(bno);
		logger.info(" testRemoveBno : " + bno);
	}
}
