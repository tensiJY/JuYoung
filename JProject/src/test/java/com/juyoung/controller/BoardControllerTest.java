package com.juyoung.controller;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration	//	컨트롤러는 @WebAppConfiguration
@ContextConfiguration(	//	모든 xml을 불러온다 -> service OR DAO 는 root-context.xml
		locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardControllerTest {
/**
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.0</version>
    <scope>provided</scope>
</dependency>
javax.servlet-api 서블릿 버전을 높인다.	
 */
	private static final Logger logger =
			LoggerFactory.getLogger(BoardControllerTest.class);
	
	@Inject
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;	
	/* 
	 * MockMvc는 브라우저에서 요청과 응답을 의미하는 객체로 간주
	 * 매번 테스트를 진행할 때마다 가상의 요청과 응답을 처리하기 위해서 setup() 메소드에서는
	 * @Before 애노테이션으로 처리되어 매번 테스트 메소드의 실행 전에 MockMvc 객체를 만들어내게 된다.
	 */
	
		
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		logger.info("	mockMvc	setup");
	}
	
	
	/*@Test
	public void testBoardList() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/Board/BoardList.park"));
		logger.info("	testBoardList Success");
	}*/
	
	/*
		MockMvc를 사용해서 perform()이라는 메소드를 실해앟게 되는데 이때 get(), post()등을
		이용해서 GET방식이나 POST 방식의 호출을 사용하게 된다.
	 */
	
	@Test
	public void testBoardWriteForm()throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/Board/BoardWriteForm.park"));
		logger.info("	testBoardWriteForm Success");
	}
}
