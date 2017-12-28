package com.juyoung.persistence;

import java.util.List;
import java.util.Map;

import com.juyoung.domain.ReportVO;

public interface ReportDAO {
	
	public int getTotalCount() throws Exception;
	
	public List<ReportVO> getReportList(Map<String, Object> map) throws Exception;

	public void writeReportProc(ReportVO rvo) throws Exception;

	public ReportVO getReportView(int rno) throws Exception;

	

}
