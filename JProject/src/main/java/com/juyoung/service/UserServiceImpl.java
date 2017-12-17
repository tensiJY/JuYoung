package com.juyoung.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.juyoung.domain.UserVO;
import com.juyoung.dto.LoginDTO;
import com.juyoung.persistence.UserDAO;
import com.juyoung.persistence.UserDAOTest;

@Service
public class UserServiceImpl implements UserService{
	
	@Inject
	private UserDAO udao;
	
	@Override
	public UserVO login(LoginDTO ldto) throws Exception {
		return udao.login(ldto);
	}
}
