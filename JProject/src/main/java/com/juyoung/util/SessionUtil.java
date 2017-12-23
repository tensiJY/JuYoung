package com.juyoung.util;

import javax.servlet.http.HttpSession;

import com.juyoung.domain.UserVO;

public class SessionUtil {
		
	public static boolean isLogin(HttpSession session, String KEY){
						
		Object obj = session.getAttribute(KEY);
		
		if(obj == null){
			
			return false;
			
		}else{
			
			return true;
		}
				
	} // end

	public static String getId(HttpSession session, String key) {
		UserVO uvo = (UserVO)session.getAttribute(key);
		return uvo.getMid();
	}
	
			
	
}
