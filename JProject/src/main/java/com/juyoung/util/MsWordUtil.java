package com.juyoung.util;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;

import com.juyoung.domain.ReportVO;

public class MsWordUtil {
	
	public void makeMsWord(Object obj) throws Exception{
		ReportVO rvo = (ReportVO) obj;
					
		// path 및 폴더 생성
		String path = "C:\\Users\\juyoung\\Desktop\\msword";
		File f = new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
				
		String name = rvo.getRdate() + "_" + rvo.getRdjob() +"_" + rvo.getRname()+"_0.docx";
		
		String fileName = makeFileName(path, name);
		
		// Blank Document
		XWPFDocument document = new XWPFDocument();
		
		// Write the Document in file system
		FileOutputStream fos = new FileOutputStream(path +"\\" + fileName);
		
		// create table
		XWPFTable tOne = document.createTable();
		
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
