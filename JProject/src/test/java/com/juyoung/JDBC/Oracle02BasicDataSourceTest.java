package com.juyoung.JDBC;

import java.sql.Connection;

import javax.inject.Inject;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class Oracle02BasicDataSourceTest {

	@Inject
	private BasicDataSource ds;
	
	@Test
	public void BasicDataSourceTest() throws Exception{
		try(Connection con = ds.getConnection()){
			System.out.println(con);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
