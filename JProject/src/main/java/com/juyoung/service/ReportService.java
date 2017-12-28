package com.juyoung.service;

import java.util.List;

import com.juyoung.domain.ReportVO;

public interface ReportService {

	public List<ReportVO> getReportList() throws Exception;

	public void writeReportProc(ReportVO rvo) throws Exception;

}
