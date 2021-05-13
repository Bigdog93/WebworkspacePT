package com.koreait.board6.coment;

public class ComentVO {
	private int icmt;
	private int iboard;
	private int iuser;
	private String uid;
	private String ctnt;
	private String regdt;
	private int likecnt;
	private int dislike;
	
	
	ComentVO() {}
	
	public ComentVO(int iboard, int iuser, String ctnt) {
		this.iboard = iboard;
		this.iuser = iuser;
		this.ctnt = ctnt;
	}
	public ComentVO(int icmt, int iboard, int iuser, String uid, String ctnt, String regdt, int likecnt, int dislike) {
		this.icmt = icmt;
		this.iboard = iboard;
		this.iuser = iuser;
		this.uid = uid;
		this.ctnt = ctnt;
		this.regdt = regdt;
		this.likecnt = likecnt;
		this.dislike = dislike;
	}
	public int getIcmt() {
		return icmt;
	}
	public void setIcmt(int icmt) {
		this.icmt = icmt;
	}
	public int getIboard() {
		return iboard;
	}
	public void setIboard(int iboard) {
		this.iboard = iboard;
	}
	public int getIuser() {
		return iuser;
	}
	public void setIuser(int iuser) {
		this.iuser = iuser;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
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
