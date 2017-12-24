package com.juyoung.service;

import java.util.List;

import com.juyoung.domain.MessageVO;

public interface MessageService {

	public void create(MessageVO vo) throws Exception;
	
	public MessageVO readMessage(int meno, String mid) throws Exception;
	
	
	
	public int count(String meReceiver) throws Exception;
	
	public List<MessageVO> list(String meReceiver)throws Exception;
}
