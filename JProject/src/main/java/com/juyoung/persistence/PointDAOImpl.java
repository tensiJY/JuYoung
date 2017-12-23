package com.juyoung.persistence;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class PointDAOImpl implements PointDAO{
	
	@Inject
	private SqlSession session;
	
	private final String namespace = "POINT";
	
	@Override
	public void updatePoint(Map<String,Object> map) throws Exception {
		session.update(namespace+".updatePoint", map);		
	}
}
