package com.juyoung.persistence;

import java.util.List;
import java.util.Map;

import com.juyoung.domain.BoardVO;

public interface BoardDAO {
	
	public void insert(BoardVO bvo) throws Exception;
	
	public int count() throws Exception;
	
	public List<BoardVO> listAll(Map<String, Object> map) throws Exception;
	
	public BoardVO boardView(int bno) throws Exception;
	
	public void remove(int bno) throws Exception;
	
	public BoardVO modifyForm(int bno) throws Exception;
	
	public void modifyProc(BoardVO bvo) throws Exception;

	public List<BoardVO> searchList(Map<String, Object> map) throws Exception;

	public int searchCount(Map<String, Object> map) throws Exception;

	public BoardVO searchView(int bno) throws Exception;

	public List<BoardVO> replyList(int bno) throws Exception;

	public void replyProc(BoardVO rvo) throws Exception;

	public void removeReply(int rrno) throws Exception;

	public void replyModify(BoardVO rvo) throws Exception;

	public List<BoardVO> mSearch(BoardVO cvo) throws Exception;
	
	public List<BoardVO> getInfo(List<String> list) throws Exception;

}
