package com.juyoung.util;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.juyoung.domain.ReportVO;

public class MsWordUtil {
	
	public void makeMsWord(Object obj) throws Exception{
		ReportVO rvo = (ReportVO) obj;
		
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
				
					
		// path 및 폴더 생성
		String path = "C:\\Users\\juyoung\\Desktop\\msword";
		File f = new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
				
		String name = rvo.getRdate() + "_" + rvo.getRdjob() +"_" + rvo.getRname()+"_0.docx";
		
		String fileName = makeFileName(path, name);
		
		// Blank Document	->	다큐멘트 생성
		XWPFDocument document = new XWPFDocument();
		
		// 폰트 및 위치 셋팅
		XWPFParagraph paragraph = document.createParagraph();
		paragraph.setAlignment(ParagraphAlignment.CENTER);	// 폰트 위치
	    XWPFRun paragraphOneRunOne = paragraph.createRun();	// 폰트 셋팅 
	    paragraphOneRunOne.setBold(true);	//	볼드
	    //paragraphOneRunOne.setItalic(true);	//	이태릭
	    paragraphOneRunOne.setFontSize(13);	//	사이즈	
	    paragraphOneRunOne.setText(rtitle);	//	입력
	    paragraphOneRunOne.setUnderline(UnderlinePatterns.SINGLE); // 밑줄 종료
	    paragraphOneRunOne.addBreak();		//	종료
	   
	    
	    //	테이블을 만든다
		XWPFTable tableOne = document.createTable();
		
		//tableRow.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000))				
		//	첫번째 행을 만든다.
		XWPFTableRow tableRowOne = tableOne.getRow(0);	// 로우(0)
		tableRowOne.getCell(0).setColor("333333");	// RGB 16진수 색 지정
		tableRowOne.getCell(0).setText("성명");		// 셀에 text지정
	
		tableRowOne.addNewTableCell().setText(rname);
		tableRowOne.addNewTableCell().setText("부서명");
		tableRowOne.getCell(2).setColor("333333");
		tableRowOne.addNewTableCell().setText(rdname);
		
		//	두번째 행을 만든다. -> 첫번째 테이블의 두번째 행
		XWPFTableRow tableRowTwo = tableOne.createRow(); // 로우 생성
		tableRowTwo.getCell(0).setColor("333333");
		tableRowTwo.getCell(0).setText("직급");
		tableRowTwo.getCell(1).setText(rdjob);
		tableRowTwo.getCell(2).setColor("333333");
		tableRowTwo.getCell(2).setText("작성일");
		tableRowTwo.getCell(3).setText(rdate);	// 
		

		
		// 한칸 내림을 위해서 생성
		XWPFParagraph blank = document.createParagraph();
	    XWPFRun run = blank.createRun();
	    run.setText("");
		
	    //	금일진행사항
	    XWPFTable tableTwo = document.createTable();
		XWPFTableRow twoRowOne = tableTwo.getRow(0);
		twoRowOne.getCell(0).setColor("333333");
		twoRowOne.getCell(0).setText("금일 진행사항");
		
		
		XWPFTableRow twoRowTwo = tableTwo.createRow();
		twoRowTwo.getCell(0).setColor("333333");
		twoRowTwo.getCell(0).setText("업무시간");
		twoRowTwo.addNewTableCell().setColor("333333");
		twoRowTwo.getCell(1).setColor("333333");
		twoRowTwo.getCell(1).setText("내용");
		twoRowTwo.addNewTableCell().setColor("333333");
		twoRowTwo.getCell(2).setColor("333333");
		twoRowTwo.getCell(2).setText("비고");
		
		XWPFTableRow twoRowThree = tableTwo.createRow();
		twoRowThree.getCell(0).setColor("333333");
		twoRowThree.getCell(0).setText("08:45");
		twoRowThree.addNewTableCell().setText(rtime1);
		twoRowThree.addNewTableCell();
		
		if(rtimea != null){
			twoRowThree.getCell(2).setText(rtimea);
		}
		
		
		XWPFTableRow twoRowFour = tableTwo.createRow();
		twoRowFour.getCell(0).setColor("333333");
		twoRowFour.getCell(0).setText("09:00 - 09:30");
		twoRowFour.addNewTableCell().setText(rtime2);
		twoRowFour.addNewTableCell();
		if(rtimeb != null){
			twoRowFour.getCell(2).setText(rtimeb);
		}
		
		XWPFTableRow twoRowFive = tableTwo.createRow();
		twoRowFive.getCell(0).setColor("333333");
		twoRowFive.getCell(0).setText("09:30 - 12:00");
		twoRowFive.addNewTableCell().setText(rtime3);
		twoRowFive.addNewTableCell();
		if(rtimec != null){
			twoRowFive.getCell(2).setText(rtimec);
		}
		
		XWPFTableRow twoRowSix = tableTwo.createRow();
		twoRowSix.getCell(0).setColor("333333");
		twoRowSix.getCell(0).setText("12:00 - 13:00");
		twoRowSix.addNewTableCell().setText(rtime4);
		twoRowSix.addNewTableCell();
		if(rtimed != null){
			twoRowSix.getCell(2).setText(rtimed);
		}
		
		XWPFTableRow twoRowSeven = tableTwo.createRow();
		twoRowSeven.getCell(0).setColor("333333");
		twoRowSeven.getCell(0).setText("13:00 - 16:00");
		twoRowSeven.addNewTableCell().setText(rtime5);
		twoRowSeven.addNewTableCell();
		if(rtimee != null){
			twoRowSeven.getCell(2).setText(rtimee);
		}
		
		XWPFTableRow twoRowEight = tableTwo.createRow();
		twoRowEight.getCell(0).setColor("333333");
		twoRowEight.getCell(0).setText("16:00 - 18:00");
		twoRowEight.addNewTableCell().setText(rtime6);
		twoRowEight.addNewTableCell();
		if(rtimef != null){
			twoRowEight.getCell(2).setText(rtimef);
		}
		
		// 한칸 내림을 위해서 생성
		XWPFParagraph blank1 = document.createParagraph();
	    XWPFRun run1 = blank1.createRun();
	    run1.setText("");
		
		// 차일 진행예정사항 테이블
		XWPFTable tableThree = document.createTable();
						
		XWPFTableRow threeRowOne = tableThree.getRow(0);
		threeRowOne.getCell(0).setColor("333333");
		threeRowOne.getCell(0).setText("차일 진행예정사항");
		
		XWPFTableRow threeRowTwo = tableThree.createRow();;
		threeRowTwo.getCell(0).setText("교육 및 학습");
		threeRowTwo.addNewTableCell().setText(reduc);
		
		XWPFTableRow threeRowThree = tableThree.createRow();;
		threeRowThree.getCell(0).setText("업무보고서\r\n프로그램");
		threeRowThree.addNewTableCell().setText(rprog);
		
		// 한칸 내림을 위해서 생성
		XWPFParagraph blank2 = document.createParagraph();
		XWPFRun run2 = blank2.createRun();
		run2.setText("");
		
		// 금일 업무결과 요약 + 문제점/중요정보
		XWPFTable tableFour = document.createTable();
		XWPFTableRow fourRowOne = tableFour.getRow(0);
		fourRowOne.getCell(0).setColor("333333");
		fourRowOne.getCell(0).setText("금일 업무결과 요약");
		fourRowOne.addNewTableCell().setColor("333333");
		fourRowOne.getCell(1).setText("문제점 / 중요정보");
		
		XWPFTableRow fourRowTwo = tableFour.createRow();
		fourRowTwo.getCell(0).setText(rsumm);
		fourRowTwo.getCell(1).setText(rtrou);
		
		// 한칸 내림을 위해서 생성
		XWPFParagraph blank3 = document.createParagraph();
		XWPFRun run3 = blank3.createRun();
		run3.setText("");
		
	/*	XWPFTable tableFive = document.createTable(3, 4);
		
		for(int i=0; i<tableFive.getNumberOfRows(); i++){
			XWPFTableRow row = tableFive.getRow(i);
			int numCells = row.getTableCells().size();
			for(int j=0; j<numCells; j++){
				XWPFTableCell cell = row.getCell(j);
				cell.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1500));
			}
		}*/
		
		
		
		//	파일 생성
		// Write the Document in file system
		FileOutputStream fos = new FileOutputStream(path +"\\" + fileName);
		document.write(fos);
	    fos.close();
	    System.out.println( fileName + "	written successully");
		
	}// makeMsWord end;
	
	
	public String makeFileName(String path, String fileName){
		String oriName = fileName;
		int count = 0;
		
		File file = new File(path+"\\"+oriName);
		
		while(file.exists()){
			count++;
			
			int len = oriName.lastIndexOf(".");
			String first = oriName.substring(0, len-2);
			String second = ".docx";
			
			oriName = first+ "_"+count + second;
			file = new File(path+"\\"+oriName);
		}
		
		return oriName;
	}
	
}
