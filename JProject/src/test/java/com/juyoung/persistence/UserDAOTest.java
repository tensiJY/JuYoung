package com.juyoung.persistence;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.juyoung.domain.UserVO;
import com.juyoung.dto.LoginDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class UserDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOTest.class); 
	
	@Inject
	private UserDAO udao;
	
	@Test
	public void testLogin()throws Exception{
		LoginDTO ldto = new LoginDTO();
		ldto.setMid("user00");
		ldto.setMpw("user00");
		UserVO uvo = udao.login(ldto);
		
		logger.info(" " + uvo.getMid() + " 	" +uvo.getMpw());
	}
	

}
