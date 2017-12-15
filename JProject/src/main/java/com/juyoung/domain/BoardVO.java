package com.juyoung.domain;

import java.util.Date;

public class BoardVO {

	private int bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private Date bregdate;
	private int bviewcnt;
	private int nowPage;

	private String search;
	private String word;
	
	private int rcnt;
	
	private int rrno;
	private String rreplytext;
	private String rreplyer;
	private Date rregdate;
	private Date rrupdatedate;
	
	private String sdate;
	private String edate;
	
	

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public int getRrno() {
		return rrno;
	}

	public void setRrno(int rrno) {
		this.rrno = rrno;
	}

	public String getRreplytext() {
		return rreplytext;
	}

	public void setRreplytext(String rreplytext) {
		this.rreplytext = rreplytext;
	}

	public String getRreplyer() {
		return rreplyer;
	}

	public void setRreplyer(String rreplyer) {
		this.rreplyer = rreplyer;
	}

	public Date getRregdate() {
		return rregdate;
	}

	public void setRregdate(Date rregdate) {
		this.rregdate = rregdate;
	}

	public Date getRrupdatedate() {
		return rrupdatedate;
	}

	public void setRrupdatedate(Date rrupdatedate) {
		this.rrupdatedate = rrupdatedate;
	}

	public int getRcnt() {
		return rcnt;
	}

	public void setRcnt(int rcnt) {
		this.rcnt = rcnt;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	
	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public Date getBregdate() {
		return bregdate;
	}

	public void setBregdate(Date bregdate) {
		this.bregdate = bregdate;
	}

	public int getBviewcnt() {
		return bviewcnt;
	}

	public void setBviewcnt(int bviewcnt) {
		this.bviewcnt = bviewcnt;
	}

	@Override
	public String toString() {
		return bno + " " + btitle + " " + bcontent + " " + bwriter + " " + bregdate + " " + bviewcnt;
	}
}
