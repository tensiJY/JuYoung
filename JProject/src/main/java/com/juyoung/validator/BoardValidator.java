package com.juyoung.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.juyoung.domain.BoardVO;

public class BoardValidator implements Validator{
		
	@Override
	public boolean supports(Class<?> clazz) {
		
		return BoardVO.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		BoardVO bvo = (BoardVO)target;
		
		String bwriter = bvo.getBwriter();
		String bcontent = bvo.getBcontent();
		String btitle = bvo.getBtitle();
		
		if(bwriter == null || bwriter.trim().isEmpty()){
			errors.reject("bwriter", "작성자 없음");
			
		}
		
		if(btitle == null || btitle.trim().length() == 0){
			errors.reject("btitle", "제목 없음");
		}
		
		if(bcontent == null || bcontent.trim().isEmpty()){
			errors.reject("bcontent", "내용 없음");
		}
	}
		
	
	
	
}
