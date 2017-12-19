package com.juyoung.domain;

import java.util.Date;

public class UserVO {
	private String mno;
	private String mid;
	private String mpw;
	private String mname;
	private int mpoint;
	
	private String msession;
	private Date msessionlimit;
	
	
	
	
	public String getMsession() {
		return msession;
	}
	public void setMsession(String msession) {
		this.msession = msession;
	}
	public Date getMsessionlimit() {
		return msessionlimit;
	}
	public void setMsessionlimit(Date msessionlimit) {
		this.msessionlimit = msessionlimit;
	}
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getMpoint() {
		return mpoint;
	}
	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}
	
	
}
