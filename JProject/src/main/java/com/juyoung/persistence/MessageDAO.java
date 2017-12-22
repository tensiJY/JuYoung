package com.juyoung.persistence;

import java.util.List;

import com.juyoung.domain.MessageVO;

public interface MessageDAO {
	
	
	
	public void create(MessageVO vo) throws Exception;
		
	public MessageVO readMessage(int meno) throws Exception;
	
	public void updateState(int meno) throws Exception;
	
	public int count(String meReceiver) throws Exception;
	
	public List<MessageVO> list(String meReceiver)throws Exception;
}
