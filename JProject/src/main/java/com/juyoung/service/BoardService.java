package com.juyoung.service;

import java.util.List;
import java.util.Map;

import com.juyoung.domain.BoardVO;
import com.juyoung.util.PageUtil;

public interface BoardService {
	
	public void insert(BoardVO bvo) throws Exception; 
	
	public int count() throws Exception;
	
	public List<BoardVO> boardList(PageUtil pInfo) throws Exception;
		
	public BoardVO boardView(int bno) throws Exception;
	
	public void updateViewCnt(int bno) throws Exception;
	
	public void remove(int bno) throws Exception;
	
	public BoardVO modifyForm(int bno) throws Exception;
	
	public void modifyProc(BoardVO bvo) throws Exception;

	public List<BoardVO> searchList(Map<String, Object> map) throws Exception;

	public int searchCount(Map<String, Object> map) throws Exception;

	public BoardVO searchView(int bno) throws Exception;
	

	
}
