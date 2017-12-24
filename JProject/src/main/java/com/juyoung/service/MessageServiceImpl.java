package com.juyoung.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juyoung.domain.MessageVO;
import com.juyoung.persistence.MessageDAO;
import com.juyoung.persistence.PointDAO;

@Service
public class MessageServiceImpl implements MessageService{
			 
	
			
	@Inject
	private MessageDAO mdao;
	
	@Inject
	private PointDAO pdao;
		
	@Override
	public int count(String meReceiver) throws Exception {
		
		return mdao.count(meReceiver);
	}
	
	@Transactional
	@Override
	public void create(MessageVO vo) throws Exception {
		/*ps.updatePoint(mid, 10);*/
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("MID", vo.getMesender());
		map.put("POINT", 10);
		
		mdao.create(vo);	
		
		pdao.updatePoint(map);
	}
	
	@Override
	public List<MessageVO> list(String meReceiver) throws Exception {
		
		return mdao.list(meReceiver);
	}
	
	@Transactional
	@Override
	public MessageVO readMessage( int meno, String mid) throws Exception {
		
		mdao.updateState(meno);
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("MID", mid);
		map.put("POINT", 5);
		
		pdao.updatePoint(map); // 글을 읽는 사람은 5포인트
		return mdao.readMessage(meno);
	}
	

	
}
