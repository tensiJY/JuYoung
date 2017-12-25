package com.juyoung.controller;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.juyoung.domain.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MessageControllerTest {

	private static final Logger logger =
			LoggerFactory.getLogger(MessageControllerTest.class);
	
	@Inject
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	private MockHttpSession mockSession;
	private UserVO uvo;
	
	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		this.mockSession = new MockHttpSession();
		this.uvo = new UserVO();
				
		uvo.setMid("USER01");
		mockSession.setAttribute("USER", uvo);
		
		logger.info("	setup	");
		
	}
	
	@Test
	public void testMessageList()throws Exception{
				
		mockMvc.perform(MockMvcRequestBuilders.get("/Message/MessageList.park")
				.session(mockSession));
		
		logger.info("	success	");
	}
}
