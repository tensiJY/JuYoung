package com.juyoung.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.juyoung.domain.ReportVO;

//	4.2 V
public class ExcelView extends AbstractXlsView{	
		
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String type = (String)model.get("TYPE");
		String fileName = "";
		
		if(type.equals("list")){
			
			
		}else if(type.equals("view")){
			
			Map<String, Object> map = printView(model, workbook);
			fileName = (String)map.get("FILENAME");
			
		}
		

		response.setContentType("Application/Msexcel"); 
		response.setHeader("Content-Disposition", "ATTachment; Filename="+ fileName +".xls");
		
	}// method end

	private Map<String, Object> printView(Map<String, Object> model, Workbook workbook) throws UnsupportedEncodingException {
//		데이터 받기
		ReportVO rvo =(ReportVO)model.get("RVO");
		String rtitle = rvo.getRtitle();
		String rname = rvo.getRname();
		String rdname = rvo.getRdname();
		String rdjob = rvo.getRdjob();
		String rdate = rvo.getRdate().toString();
		String rtime1 = rvo.getRtime1();
		String rtimea = rvo.getRtimea();
		String rtime2 = rvo.getRtime2();
		String rtimeb = rvo.getRtimeb();
		String rtime3 = rvo.getRtime3();
		String rtimec = rvo.getRtimec();
		String rtime4 = rvo.getRtime4();
		String rtimed = rvo.getRtimed(); 
		String rtime5 = rvo.getRtime5();
		String rtimee = rvo.getRtimee(); 
		String rtime6 = rvo.getRtime6();
		String rtimef = rvo.getRtimef();
		
		String reduc = rvo.getReduc();
		String rprog = rvo.getRprog();
		String rsumm = rvo.getRsumm();
		String rtrou = rvo.getRtrou();
		
		//	파일 이름 설정
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String d = sdf.format(rvo.getRdate());
		String fileName = "";
		
		int rno = rvo.getRno();
		if(rno != 0){
			fileName = d + "_"+rvo.getRname() +"_"+ rvo.getRno();
		}else {
			fileName = d + "_0.xls";
		}
		
		
		fileName = URLEncoder.encode(fileName, "UTF-8");
		
		//	워크 시트
		HSSFSheet worksheet = (HSSFSheet) workbook.createSheet(rtitle+"_"+rname);
		// 	worksheet.setColumnWidth(columnIndex, width);
		//	로우	0
		HSSFRow row = worksheet.createRow(0);
		//row.setHeight((short)15);
		
		HSSFCell c1= row.createCell(0);
		
		c1.setCellValue(rtitle);
		
		//	로우	2-3
		row = worksheet.createRow(2);
		HSSFCell ce0 = row.createCell(0);
		ce0.setCellValue("성  명");
		HSSFCell ce1 = row.createCell(1);
		ce1.setCellValue(rname);
		HSSFCell ce2 = row.createCell(2);
		ce2.setCellValue("부서명");
		HSSFCell ce3 = row.createCell(3);
		ce3.setCellValue(rdname);
		row = worksheet.createRow(3);
		HSSFCell ce4 = row.createCell(0);
		ce4.setCellValue("직  급");
		HSSFCell ce5 = row.createCell(1);
		ce5.setCellValue(rdjob);
		HSSFCell ce6 = row.createCell(2);
		ce6.setCellValue("작성일");
		HSSFCell ce7 = row.createCell(3);
		ce7.setCellValue(rdate);
		
		// 쎌 스타일
		HSSFCellStyle style = (HSSFCellStyle) workbook.createCellStyle();
		
		style.setBorderBottom(BorderStyle.MEDIUM);
		style.setBorderLeft(BorderStyle.MEDIUM);
		style.setBorderRight(BorderStyle.MEDIUM);
		style.setBorderTop(BorderStyle.MEDIUM);		
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		style.setRightBorderColor(HSSFColor.BLACK.index);
		style.setTopBorderColor(HSSFColor.BLACK.index);
		
		ce0.setCellStyle(style);
		ce1.setCellStyle(style);
		ce2.setCellStyle(style);
		ce3.setCellStyle(style);
		ce4.setCellStyle(style);
		ce5.setCellStyle(style);
		ce6.setCellStyle(style);
		ce7.setCellStyle(style);
		
		//	로우	5 - 12
		row = worksheet.createRow(5);
		row.createCell(0).setCellValue("금일 진행 사항");
		row.createCell(1);
		row.createCell(2);
		worksheet.addMergedRegion(new CellRangeAddress(5, 5, 0, 2));	// 셀병합
		
		row = worksheet.createRow(6);
		row.createCell(0).setCellValue("업무시간");
		
		row = worksheet.createRow(7);
		row.createCell(0).setCellValue("08:45");
		row.createCell(1).setCellValue(rtime1);
		HSSFCell cra1 = row.createCell(2);
		if( rtimea != null){
			cra1.setCellValue(rtimea);
		}
		
		row = worksheet.createRow(8);
		row.createCell(0).setCellValue("09:00 - 09:30");
		row.createCell(1).setCellValue(rtime2);
		HSSFCell cra2 = row.createCell(2);
		if( rtimeb != null){
			cra2.setCellValue(rtimeb);
		}
				
		row = worksheet.createRow(9);
		row.createCell(0).setCellValue("09:30 - 12:00");
		row.createCell(1).setCellValue(rtime3);
		HSSFCell cra3 = row.createCell(2);
		if( rtimec != null){
			cra3.setCellValue(rtimec);
		}
		
		row = worksheet.createRow(10);
		row.createCell(0).setCellValue("12:00 - 13:00");
		row.createCell(1).setCellValue(rtime4);
		HSSFCell cra4 = row.createCell(2);
		if( rtimec != null){
			cra4.setCellValue(rtimed);
		}
		
		row = worksheet.createRow(11);
		row.createCell(0).setCellValue("13:00 - 16:00");
		row.createCell(1).setCellValue(rtime5);
		HSSFCell cra5 = row.createCell(2);
		if( rtimee != null){
			cra5.setCellValue(rtimee);
		}
		row = worksheet.createRow(12);
		row.createCell(0).setCellValue("13:00 - 16:00");
		row.createCell(1).setCellValue(rtime6);
		HSSFCell cra6 = row.createCell(2);
		if( rtimef != null){
			cra6.setCellValue(rtimef);
		}
		
		//	14-16
		row = worksheet.createRow(14);
		row.createCell(0).setCellValue("차일 진행 예정 사항");
		row.createCell(1);
		row.createCell(2);
		worksheet.addMergedRegion(new CellRangeAddress(14, 14, 0, 2));	// 셀병합
		row = worksheet.createRow(15);
		row.createCell(0).setCellValue("교육 및 학습");
		row.createCell(1).setCellValue(reduc);
		row = worksheet.createRow(16);
		row.createCell(0).setCellValue("업무보고서 \r\n 프로그램");
		row.createCell(1).setCellValue(rprog);
		
		//	18-19
		row = worksheet.createRow(18);
		row.createCell(0).setCellValue("금일 업무결과 요약");
		row.createCell(1).setCellValue("문제점/중요정보");
		
		row = worksheet.createRow(19);
		row.createCell(0).setCellValue(rsumm);
		row.createCell(1).setCellValue(rtrou);
		
		Map<String, Object> map = new HashedMap<String, Object>();
		
		map.put("FILENAME", fileName);
		map.put("WORKSHEET", worksheet);
		return map;
	}//printView end
	
	
	public String makeExcel(Map<String, Object> model) throws Exception{
		
		
		//	새로운 워크북 생성
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		//	파라미터로 RVO 와 workbook 넘겨줌
		Map<String, Object> map = printView(model, workbook);
		
		//	sheet를 받아서 워크북까지 가져옮
		HSSFSheet worksheet = (HSSFSheet) map.get("WORKSHEET");
		workbook = worksheet.getWorkbook();
		
		//	파일이름을 가져와서 파일패스에 excel파일 저장
		String fileName = (String) map.get("FILENAME");
		String path =(String) model.get("FILEPATH");
		
		File file = new File(path);
		
		if(!file.exists()){
			file.mkdirs();
		}
		
		fileName = makeFileName(fileName, path);
		
		FileOutputStream fos = new FileOutputStream(new File(path+"\\"+fileName));
		workbook.write(fos);
		fos.close();
		workbook.close();
		
		return fileName;
	}// method end	

	private String makeFileName(String fileName, String filePath) {
		String oriName = fileName;
		int count = 0;
		
		File file = new File(filePath+"\\"+oriName);
		// fileName = d + "_"+rvo.getRname()+"_0.xls";
		while(file.exists()){
			count++;
			
			int len = oriName.lastIndexOf("_");
			String pre = oriName.substring(0, len);
			String next = ".xls";
			
			oriName = pre + "_" + count + next;
			
			file = new File(filePath+"\\"+oriName);
		}
		
		return oriName;
	}// method end
}
