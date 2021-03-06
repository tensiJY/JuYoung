package com.juyoung.service;

import java.util.Date;

import com.juyoung.domain.UserVO;
import com.juyoung.dto.LoginDTO;

public interface UserService {
	
	public UserVO login(LoginDTO ldto) throws Exception;
	
	public void keepLogin(String uid, String sessionId, Date next);
	
	public UserVO checkUserWithSessionKey(String value);
}
