package com.juyoung.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.juyoung.domain.FileVO;
import com.juyoung.util.StringUtil;


public class FileValidator implements Validator{

	private String writer;
	private String title;
	private String pw;
	private String body;
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		FileVO fvo = (FileVO) target;
		this.writer = (String) fvo.getWriter();
		this.title = (String) fvo.getTitle();
		this.pw = (String) fvo.getPw();
		this.body = (String) fvo.getBody();
		
		if(StringUtil.isNull(writer)){
			errors.reject("01", "작성자 null");
		}
		
		if(StringUtil.isNull(title)){
			errors.reject("02", "제목 null");
		}
		
	}
	
	
}
