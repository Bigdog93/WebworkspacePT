package com.koreait.board6.board;

public class BoardVO {
	private int iboard;
	private String title;
	private String ctnt;
	private int iuser;
	private String regdt;
	private int likecnt;
	private int dislike;
	private int viewcnt;
	
	private String unm;
	
	public BoardVO() {}
	
	public BoardVO(String title, String ctnt, int iuser) {
		this(0, title, ctnt, iuser, null, 0, 0, 0);
	}
	
	public BoardVO(int iboard, String title, String unm, String regdt) {
		this(iboard, title, null, 0, regdt, 0, 0, 0);
		this.unm = unm;
	}
	
	public BoardVO(int iboard, String title, String ctnt, int iuser, String regdt, int likecnt, int dislike,
			int viewcnt) {
		this.iboard = iboard;
		this.title = title;
		this.ctnt = ctnt;
		this.iuser = iuser;
		this.regdt = regdt;
		this.likecnt = likecnt;
		this.dislike = dislike;
		this.viewcnt = viewcnt;
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
	public int getIuser() {
		return iuser;
	}
	public void setIuser(int iuser) {
		this.iuser = iuser;
	}
	public String getRegdt() {
		return regdt;
	}
	public void setRegdt(String regdt) {
		this.regdt = regdt;
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
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public String getUnm() {
		return unm;
	}

	public void setUnm(String unm) {
		this.unm = unm;
	}
}
