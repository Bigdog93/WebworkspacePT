package com.koreait.board4;

public class BoardVO {
	private int iboard;
	private String title;
	private String ctnt;
	private String regdt;
	private int viewcnt;
	private int cmt_cnt;
	
	BoardVO() {}
	BoardVO(String title, String ctnt) {
		this.title = title;
		this.ctnt = ctnt;
	}
	BoardVO(int iboard, String title, String ctnt, String regdt) {
		this(title, ctnt);
		this.iboard = iboard;
		this.regdt = regdt;
	}
	BoardVO(int iboard, String title, String regdt, int viewcnt, int cmt_cnt) {
		this.iboard = iboard;
		this.title = title;
		this.regdt = regdt;
		this.viewcnt = viewcnt;
		this.cmt_cnt = cmt_cnt;
		
	}
	public int getIboard() {
		return iboard;
	}
	public void setIboard(int iboard) {
		this.iboard = iboard;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCtnt() {
		return ctnt;
	}
	public void setCtnt(String ctnt) {
		this.ctnt = ctnt;
	}
	public String getRegdt() {
		return regdt;
	}
	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public int getCmt_cnt() {
		return cmt_cnt;
	}
	public void setCmt_cnt(int cmt_cnt) {
		this.cmt_cnt = cmt_cnt;
	}
}
