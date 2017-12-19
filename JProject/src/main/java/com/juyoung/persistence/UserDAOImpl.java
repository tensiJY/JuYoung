package com.juyoung.persistence;

import java.util.Date;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.juyoung.domain.UserVO;
import com.juyoung.dto.LoginDTO;

@Repository
public class UserDAOImpl implements UserDAO{
	
	
	@Inject
	private SqlSession session;
	
	private String namespace = "User";
	
	@Override
	public UserVO login(LoginDTO ldto) throws Exception {
		return session.selectOne(namespace+".login", ldto);
	}
	
	@Override
	public UserVO checkUserWithSessionKey(String value) {
		
		return session.selectOne(namespace+".checkUserWithSessionKey", value);
	}
	
	@Override
	public void keepLogin(Map<String, Object> map) {
		session.update(namespace+".keepLogin", map);		
	}
}
