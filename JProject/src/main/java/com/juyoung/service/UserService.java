package com.juyoung.service;

import com.juyoung.domain.UserVO;
import com.juyoung.dto.LoginDTO;

public interface UserService {
	
	public UserVO login(LoginDTO ldto) throws Exception;
}
