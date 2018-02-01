package com.juyoung.util;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	private final Logger logger = 
			LoggerFactory.getLogger(FileUtil.class);
	
	
	public String uploadFile(MultipartFile oriFile, String name, String path){
		name = renameFile(name, path);
		
		File copyFile = new File(path+"\\"+name);
		
		try{
			
			oriFile.transferTo(copyFile);
			
		}catch(Exception e){logger.info(e.toString()); }
		
		return name;
	}// uploadFile end
	
	
	private String renameFile(String name, String path){
		int count = 0;
		String oriName = name;
		String fileFolder = path;
		
		File file = new File(fileFolder);
		if(!file.exists()){
			file.mkdirs();
		}
		
		file = new File(path +"\\"+oriName);
		
		while(file.exists()){
			count++;
			int pos = name.lastIndexOf(".");
			String first = name.substring(0, pos);
			String last = name.substring(pos);
			
			oriName = first+"_"+count+last;
			
			file = new File(path +"\\"+oriName);
		}
		return oriName;
	}// method renameFile end
	
}// class end
