package com.juyoung.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.juyoung.domain.UserVO;

public class UserValidator implements Validator{
	
	private static final Logger logger =
			LoggerFactory.getLogger(UserValidator.class);
	
/*	private static final int MINIMUM_ID_LENGTH = 4;
	private static final int MINIMUM_PASSWORD_LENGTH = 6;
	private static final int MINIMUM_NAME_LENGTH = 2;
*/

	@Override
	public boolean supports(Class<?> clazz) {
		//	검증할 객체의 클래스 타입정보
		
		return UserVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//	
		
		UserVO uvo = (UserVO)target;
		String mid = uvo.getMid();
		String mpw = uvo.getMpw();
		String mname = uvo.getMname();
		
		if(mid== null || mid.trim().isEmpty()){
			
			errors.reject("ID", "null");
		}else if(mid.length()<4){
			errors.reject("ID", "4보다 작음");
		}else if(mid.length()>13){
			errors.reject("ID", "13보다 큼");
		}
		
		if(mpw== null || mpw.trim().isEmpty()){
			
			errors.reject("PW", "null");
		}
		
	}//method validate end;

	
}//class UserValidator end; 
