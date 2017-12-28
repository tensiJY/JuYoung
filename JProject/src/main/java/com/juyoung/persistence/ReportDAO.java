package com.juyoung.persistence;

import java.util.List;

import com.juyoung.domain.ReportVO;

public interface ReportDAO {

	public List<ReportVO> getReportList() throws Exception;

	public void writeReportProc(ReportVO rvo) throws Exception;

}
