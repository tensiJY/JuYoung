package com.juyoung.util;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.juyoung.domain.BoardVO;

public class ExcelUtil {
	
	public static void makeXls(List<BoardVO> list){
		int len = list.size();
		
		//	워크북 생성
        HSSFWorkbook workbook = new HSSFWorkbook();
        

	}
	
	public static void makeXlsx(List<BoardVO> list){
		for(int i=0; i<list.size();i++){
			System.out.println(list.get(i).getBno());
		}
		
		//	워크북 생성
		XSSFWorkbook workBook = new XSSFWorkbook();
		//	워크시트 생성
		XSSFSheet sheet = workBook.createSheet();
		//	행 생성
		XSSFRow row = sheet.createRow(0);
		//	셀 생성
		XSSFCell cell;
		
		//	헤더 정보 구성
		cell = row.createCell(1);
		cell.setCellValue("번호");
		
		cell = row.createCell(2);
		cell.setCellValue("제목");
		
		cell = row.createCell(3);
		cell.setCellValue("작성자");
		
		cell = row.createCell(4);
		cell.setCellValue("내용");
		
		cell = row.createCell(5);
		cell.setCellValue("작성일");
		
		// 리스트의 size 만큼 row를 생성
		for(int rowIndex=0; rowIndex<list.size(); rowIndex++){
			BoardVO bvo = list.get(rowIndex);
			
			//	행 생성
			row = sheet.createRow(rowIndex+1);
			
			cell = row.createCell(1);
			cell.setCellValue(bvo.getBno());
			
			cell = row.createCell(2);
			cell.setCellValue(bvo.getBtitle());
			
			cell = row.createCell(3);
			cell.setCellValue(bvo.getBwriter());
			
			cell = row.createCell(4);
			cell.setCellValue(bvo.getBcontent());
			
			cell = row.createCell(5);
			cell.setCellValue(bvo.getBregdate());
			
		}// for end

		FileOutputStream fos = null;
		try {
			 fos = new FileOutputStream("C:\\Users\\juyoung\\Desktop\\excel\\test.xlsx");
			//파일을 쓴다
			workBook.write(fos);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//필수로 닫아주어야함
			try {
				fos.close();
				workBook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("엑셀파일생성성공");

			
		
	}// makeXlsx end
	
	
}
