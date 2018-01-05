package com.juyoung.service;

import java.util.List;

import com.juyoung.domain.ReportVO;
import com.juyoung.util.PageUtil;

public interface ReportService {
	
	public int getTotalCount() throws Exception;
	
	public List<ReportVO> getReportList(PageUtil pInfo) throws Exception;

	public void writeReportProc(ReportVO rvo) throws Exception;

	public ReportVO getReportView(int rno) throws Exception;

	public void reportPrint(String rno) throws Exception;

	public List<ReportVO> reportExcelList(String[] chb2) throws Exception;

	public void sendMail(ReportVO rvo) throws Exception;

	

}
