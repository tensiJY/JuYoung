package com.juyoung.persistence;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAO05TestRemoveBno {
	
	private final Logger logger = org.slf4j.LoggerFactory.getLogger(BoardDAO05TestRemoveBno.class);
	
	@Inject
	private BoardDAO bdao;
	
	@Test
	public void testRemoveBno()throws Exception{
		int bno = 10;
		
		bdao.remove(bno);
		
		logger.info(" removebno : " + bno);
	}
	
	
}
