package com.juyoung.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.juyoung.domain.MessageVO;
import com.juyoung.persistence.MessageDAO;
import com.juyoung.persistence.PointDAO;

@Service
public class MessageServiceImpl implements MessageService{
	
	private static final Logger logger =
			LoggerFactory.getLogger(MessageServiceImpl.class);
			
	@Inject
	private MessageDAO mdao;
	
		
	@Override
	public int count(String meReceiver) throws Exception {
		
		return mdao.count(meReceiver);
	}
	
	@Override
	public void create(MessageVO vo) throws Exception {
		mdao.create(vo);		
	}
	
	@Override
	public List<MessageVO> list(String meReceiver) throws Exception {
		
		return mdao.list(meReceiver);
	}
	
	@Override
	public MessageVO readMessage( int meno) throws Exception {
		mdao.updateState(meno);
		return mdao.readMessage(meno);
	}
	

	
}
