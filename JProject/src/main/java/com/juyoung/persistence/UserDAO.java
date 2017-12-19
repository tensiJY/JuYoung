package com.juyoung.persistence;

import java.util.Map;

import com.juyoung.domain.UserVO;
import com.juyoung.dto.LoginDTO;

public interface UserDAO {
	
	public UserVO login(LoginDTO ldto) throws Exception;

	public UserVO checkUserWithSessionKey(String value);
	
	public void keepLogin(Map<String, Object> map);
}
