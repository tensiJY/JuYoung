package com.juyoung.util;

import javax.servlet.http.HttpSession;

public class SessionUtil {
		
	public static boolean isLogin(HttpSession session, String KEY){
						
		Object obj = session.getAttribute(KEY);
		
		if(obj == null){
			
			return false;
			
		}else{
			
			return true;
		}
				
	} // end
	
			
	
}
