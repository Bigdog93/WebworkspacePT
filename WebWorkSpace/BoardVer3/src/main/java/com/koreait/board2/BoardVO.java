package com.koreait.board2;

public class BoardVO { // 테이블 레코드 하나에 맵핑되는 칭구야
	private String title;
	private String ctnt;
	private int viewcnt;
	private int likecnt;
	private int dislike;
	
	BoardVO() {}
	BoardVO(String title, String ctnt) {
		this.title = title;
		this.ctnt = ctnt;
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
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public int getLikecnt() {
		return likecnt;
	}
	public void setLikecnt(int likecnt) {
		this.likecnt = likecnt;
	}
	public int getDislike() {
		return dislike;
	}
	public void setDislike(int dislike) {
		this.dislike = dislike;
	}
	
}
