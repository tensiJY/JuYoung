package com.juyoung.domain;

import org.springframework.web.multipart.MultipartFile;

public class FileVO {
	//	데이터를 기억할 변수를 만든다.
	//	엄밀히 말해서 실무에서는 변수를 만들때 public으로 하지 않는 것을 원칙으로 한다.
	//	이 이유는?
	//	==>		데이터는 은닉화 시킨다.
	//		예를 들어		private String title;
	//		사용할 때		setTitle("재목");			을 이용해서 데이터를 기억하고
	//						getTitle();					을 이용해서 데이터를 꺼내야 한다.
	
	private String writer;
	private String title;
	private String body;
	private String pw;
	private MultipartFile[] files;
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public MultipartFile[] getFiles() {
		return files;
	}
	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}
	
	
	
}
