package com.juyoung.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.juyoung.domain.MessageVO;

public class MessageDAOImpl implements MessageDAO {
	
	private static final Logger logger =
			LoggerFactory.getLogger(MessageDAOImpl.class);
	
	
	@Inject
	private SqlSession session;
	
	
	@Override
	public void create(MessageVO vo) throws Exception {
		
		
	}
	
	@Override
	public MessageVO readMessage(int meno) throws Exception {
		
		return null;
	}
	
	@Override
	public void updateState(int meno) throws Exception {
				
	}
}
