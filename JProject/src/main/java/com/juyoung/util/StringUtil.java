package com.juyoung.util;

public class StringUtil {
	
	public static boolean isNull(String target){
				
		if(target==null || target.trim().length()==0){
			
			return true;
			
		}else{
			
			return false;
			
		}
		
	}// isNull end;
	
	public static String sliceFirst(String target, String type){
		String temp = target;
		
		int len = temp.indexOf(type);
		
		if(len == -1){
	
			return temp;
		}else {
			
			temp = temp.substring(0, len);
			
			return temp;
		}
		
	}
	
	public static String sliceSecond(String target, String type){
		String temp = target;
		
		int len = temp.indexOf(type);
		int len2 = type.length();
		
		if(len == -1){
			
			return temp;
			
		}else {
			
			temp = temp.substring(len+len2);
			
			return temp;
		}
		
	}//sliceSecond
	
}
