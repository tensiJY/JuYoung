package com.juyoung.persistence;

import java.util.List;

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
	public List<ReportVO> getReportList() throws Exception {
		return sql.selectList(namespace+".getReportList");
	}
	
	@Override
	public void writeReportProc(ReportVO rvo) throws Exception {
		sql.insert(namespace+".reportProc", rvo);	
	}
	
}
