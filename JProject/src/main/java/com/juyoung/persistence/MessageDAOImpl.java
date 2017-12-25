package com.juyoung.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.juyoung.domain.MessageVO;

@Repository
public class MessageDAOImpl implements MessageDAO {
	
	
	
	private String namespace = "MessageMapper";
	
	@Inject
	private SqlSession session;
	
	
	@Override
	public void create(MessageVO vo) throws Exception {
		session.insert(namespace + ".create", vo);		
	}
	
	@Override
	public MessageVO readMessage(int meno) throws Exception {
		
		return session.selectOne(namespace+".readMessage", meno);
	}
	
	@Override
	public void updateState(int meno) throws Exception {
		session.update(namespace+".updateState", meno);		
	}
	
	@Override
	public int count(String meReceiver) throws Exception {
		return session.selectOne(namespace+".count", meReceiver) ;
	}
	
	@Override
	public List<MessageVO> list(String meReceiver) throws Exception {
		return session.selectList(namespace+".list", meReceiver);
	}
}
