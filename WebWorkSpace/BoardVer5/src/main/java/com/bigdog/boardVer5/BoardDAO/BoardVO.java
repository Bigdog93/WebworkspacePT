package com.bigdog.boardVer5.BoardDAO;

public class BoardVO {
	private int iboard;
	private String title;
	private String ctnt;
	private String regdt;
	private int viewcnt;
	private int likecnt;
	private int dislike;
	private int cmtcnt;
	
	public BoardVO() {}
	
	public BoardVO(String title, String ctnt) {
		this(0, title, ctnt, null, 0, 0, 0);
	}
	
	public BoardVO(int iboard, String title, String ctnt) {
		this(title, ctnt);
		this.iboard = iboard;
	}
	
	public BoardVO(int iboard, String title, String regdt, int viewcnt, int likecnt, int dislike, int cmtcnt) {
		this(iboard, title, null, regdt, viewcnt, likecnt, dislike);
		this.cmtcnt = cmtcnt;
	}
	
	public BoardVO(int iboard, String title, String ctnt, String regdt, int viewcnt, int likecnt, int dislike) {
		this.iboard = iboard;
		this.title = title;
		this.ctnt = ctnt;
		this.regdt = regdt;
		this.viewcnt = viewcnt;
		this.likecnt = likecnt;
		this.dislike = dislike;
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

	public int getCmtcnt() {
		return cmtcnt;
	}

	public void setCmtcnt(int cmtcnt) {
		this.cmtcnt = cmtcnt;
	}
}
