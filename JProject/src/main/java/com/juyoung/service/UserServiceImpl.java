package com.juyoung.service;

import java.util.Date;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.stereotype.Service;

import com.juyoung.domain.UserVO;
import com.juyoung.dto.LoginDTO;
import com.juyoung.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService{
	
	@Inject
	private UserDAO udao;
	
	@Override
	public UserVO login(LoginDTO ldto) throws Exception {
		return udao.login(ldto);
	}
	
	@Override
	public UserVO checkUserWithSessionKey(String value) {
		
		return udao.checkUserWithSessionKey(value);
	}
	
	@Override
	public void keepLogin(String uid, String sessionId, Date next) {
		Map<String, Object>map = new HashedMap<String, Object>();
		map.put("MID", uid);
		map.put("SESSIONID", sessionId);
		map.put("NEXT", next);
		udao.keepLogin(map);		
	}
}
