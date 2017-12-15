package com.juyoung.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import com.juyoung.domain.BoardVO;
import com.juyoung.persistence.BoardDAO;
import com.juyoung.util.PageUtil;



@Service
public class BoardServiceImpl implements BoardService{
	
	private static final Logger logger = 
			LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Inject
	private BoardDAO bdao;
	
	@Override
	public void insert(BoardVO bvo) throws Exception {
		logger.info("	insert" + bvo.getBcontent());
		bdao.insert(bvo);		
	}
	
	
	@Override
	public int count() throws Exception {
		return bdao.count();
	}
	
	@Override
	public List<BoardVO> boardList(PageUtil pInfo) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("START", pInfo.start);
		map.put("END", pInfo.end);
		
		return bdao.listAll(map);
	}
	
		
	
	@Override
	public BoardVO boardView(int bno) throws Exception {
		logger.info("	BoardView()	");
		return bdao.boardView(bno);
	}
	
	@Override
	public void updateViewCnt(int bno) throws Exception {
			
	}
	
	@Override
	public void remove(int bno) throws Exception {
		logger.info("	removeBno : " + bno);
		bdao.remove(bno);
	}
	
	@Override
	public BoardVO modifyForm(int bno) throws Exception {
		return bdao.modifyForm(bno);
	}
	
	@Override
	public void modifyProc(BoardVO bvo) throws Exception {
		bdao.modifyProc(bvo);		
	}
	
	@Override
	public List<BoardVO> searchList(Map<String, Object> map) throws Exception {
		PageUtil pInfo =(PageUtil)map.get("PINFO");
		map.put("START", pInfo.start);
		map.put("END", pInfo.end);
		return bdao.searchList(map);
	}
	
	@Override
	public int searchCount(Map<String, Object> map) throws Exception {
		return bdao.searchCount(map);
	}
	
	@Override
	public BoardVO searchView(int bno) throws Exception {
		return bdao.searchView(bno);
	}
	
	@Override
	public List<BoardVO> replyList(int bno) throws Exception {
		return bdao.replyList(bno);
	}
	
	@Override
	public void replyProc(BoardVO rvo) throws Exception {
		bdao.replyProc(rvo);
	}
	
	@Override
	public void removeReply(int rrno) throws Exception {
		bdao.removeReply(rrno);
	}
	
	@Override
	public void replyModify(BoardVO rvo) throws Exception {
		bdao.replyModify(rvo);
	}
}
