package com.juyoung.persistence;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.juyoung.domain.ReportVO;

@Repository
public class ReportDAOImpl implements ReportDAO{
	
	private static final Logger  logger =
			LoggerFactory.getLogger(ReportDAOImpl.class);

	private String namespace = "report";
		
	@Inject
	private SqlSession sql;
	
	@Override
	public int getTotalCount() throws Exception {
		
		return sql.selectOne(namespace+".getTotalCount");
	}
	
	
	@Override
	public List<ReportVO> getReportList(Map<String, Object> map) throws Exception {
		return sql.selectList(namespace+".getReportList", map);
	}
	
	@Override
	public void writeReportProc(ReportVO rvo) throws Exception {
		sql.insert(namespace+".reportProc", rvo);	
	}
	
	@Override
	public ReportVO getReportView(int rno) throws Exception {
		return sql.selectOne(namespace+".reportView", rno);
	}
}
