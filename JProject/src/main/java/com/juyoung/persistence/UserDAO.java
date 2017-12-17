package com.juyoung.persistence;

import com.juyoung.domain.UserVO;
import com.juyoung.dto.LoginDTO;

public interface UserDAO {
	
	public UserVO login(LoginDTO ldto) throws Exception;
}
