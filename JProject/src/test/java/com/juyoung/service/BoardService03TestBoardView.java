package com.juyoung.service;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.juyoung.domain.BoardVO;
import com.juyoung.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardService03TestBoardView {
	
	@Inject
	private BoardDAO bdao;
	
	@Test
	public void testBoardView()throws Exception{
		BoardVO bvo = bdao.boardView(1);
		System.out.println(bvo.getBno() + " " + bvo.getBtitle() + " " + bvo.getBwriter());
	}
}
