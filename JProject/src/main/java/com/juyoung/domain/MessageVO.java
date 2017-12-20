package com.juyoung.domain;

import java.util.Date;

public class MessageVO {
	
	private int meno;
	private String meSender;
	private String meReceiver;
	private String meText;
	private Date meSendDate;
	private Date meReadDate;
	private String meIsShow;
	
	public int getMeno() {
		return meno;
	}
	public void setMeno(int meno) {
		this.meno = meno;
	}
	public String getMeSender() {
		return meSender;
	}
	public void setMeSender(String meSender) {
		this.meSender = meSender;
	}
	public String getMeReceiver() {
		return meReceiver;
	}
	public void setMeReceiver(String meReceiver) {
		this.meReceiver = meReceiver;
	}
	public String getMeText() {
		return meText;
	}
	public void setMeText(String meText) {
		this.meText = meText;
	}
	public Date getMeSendDate() {
		return meSendDate;
	}
	public void setMeSendDate(Date meSendDate) {
		this.meSendDate = meSendDate;
	}
	public Date getMeReadDate() {
		return meReadDate;
	}
	public void setMeReadDate(Date meReadDate) {
		this.meReadDate = meReadDate;
	}
	public String getMeIsShow() {
		return meIsShow;
	}
	public void setMeIsShow(String meIsShow) {
		this.meIsShow = meIsShow;
	}
	
	
}
