package com.juyoung.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.juyoung.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	private String namespace = "board";
	
	@Inject
	private SqlSession session;
	
	@Override
	public void insert(BoardVO bvo) throws Exception {
		logger.info("	insert	" + " " + bvo.getBtitle());
		session.insert(namespace+".insert", bvo);		
	}
	
	@Override
	public int count() throws Exception {
		return (Integer)session.selectOne(namespace+".count");
	}
	
	
	@Override
	public List<BoardVO> listAll(Map<String, Object> map) throws Exception {
		
		return session.selectList(namespace+".list", map);
	}
	
	@Override
	public BoardVO boardView(int bno) throws Exception {
		
		return session.selectOne(namespace+".boardView", bno);
	}
	
	@Override
	public void remove(int bno) throws Exception {
		logger.info("	remove : " + bno);
		session.delete(namespace+".remove", bno);
	}
	
	@Override
	public BoardVO modifyForm(int bno) throws Exception {
		logger.info(" modifyForm : " + bno);
		return session.selectOne(namespace + ".modifyForm" , bno);
	}
	
	@Override
	public void modifyProc(BoardVO bvo) throws Exception {
		session.update(namespace + ".modifyProc", bvo);		
	}
	
	@Override
	public List<BoardVO> searchList(Map<String, Object> map) throws Exception {
		return session.selectList(namespace + ".searchList", map);
	}
	
	@Override
	public int searchCount(Map<String, Object> map) throws Exception {
		return session.selectOne(namespace+".searchCount", map);
	}
	
	@Override
	public BoardVO searchView(int bno) throws Exception {
		return session.selectOne(namespace+".searchView", bno);
	}
	
	@Override
	public List<BoardVO> replyList(int bno) throws Exception {
		return session.selectList(namespace+".replyList", bno);
	}
	
	@Override
	public void replyProc(BoardVO rvo) throws Exception {
		session.insert(namespace+".replyProc", rvo);
	}
	
	@Override
	public void removeReply(int rrno) throws Exception {
		session.delete(namespace+".removeReply", rrno);
	}
}
