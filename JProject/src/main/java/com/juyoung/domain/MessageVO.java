package com.juyoung.domain;

import java.util.Date;

public class MessageVO {
	
	private int meno;
	private String mesender;
	private String mereceiver;
	private String metext;
	private Date mesenddate;
	private Date mereaddate;
	private String meisshow;
	public int getMeno() {
		return meno;
	}
	public void setMeno(int meno) {
		this.meno = meno;
	}
	public String getMesender() {
		return mesender;
	}
	public void setMesender(String mesender) {
		this.mesender = mesender;
	}
	public String getMereceiver() {
		return mereceiver;
	}
	public void setMereceiver(String mereceiver) {
		this.mereceiver = mereceiver;
	}
	public String getMetext() {
		return metext;
	}
	public void setMetext(String metext) {
		this.metext = metext;
	}
	public Date getMesenddate() {
		return mesenddate;
	}
	public void setMesenddate(Date mesenddate) {
		this.mesenddate = mesenddate;
	}
	public Date getMereaddate() {
		return mereaddate;
	}
	public void setMereaddate(Date mereaddate) {
		this.mereaddate = mereaddate;
	}
	public String getMeisshow() {
		return meisshow;
	}
	public void setMeisshow(String meisshow) {
		this.meisshow = meisshow;
	}
	
	@Override
	public String toString(){
		return " " + meno + " " + mesender + " " + mereceiver + " " + metext;
	}
	
	
}
