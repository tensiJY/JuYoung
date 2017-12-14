package com.juyoung.persistence;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.juyoung.domain.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAO04TestModifyForm {
	
	@Inject
	private BoardDAO bdao;
	
	@Test
	public void testModifyForm()throws Exception{
		int bno = 15;
		BoardVO bvo = bdao.modifyForm(bno);
		System.out.println(bvo.getBcontent() + " " + bvo.getBtitle());
	}
	
	
}
