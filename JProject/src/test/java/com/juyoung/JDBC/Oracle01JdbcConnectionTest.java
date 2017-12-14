package com.juyoung.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;


public class Oracle01JdbcConnectionTest {
	

	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl1";
	
	private static final String ID = "juyoung";
	
	private static final String PW = "juyoung";
	
	/*
	 * 스프링과 jdbc 드라이버를 연결하기 위한 라이브러리	
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>${org.springframework-version}</version>
		</dependency> 
	*/
	
	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		System.out.println(" 드라이버로딩 성공");
		
		try(Connection conn = DriverManager.getConnection(URL, ID, PW);){
			
			System.out.println(" 접속 성공	" + conn);
			
		}catch(Exception e){
			
			System.out.println(e);
		}
	}

}