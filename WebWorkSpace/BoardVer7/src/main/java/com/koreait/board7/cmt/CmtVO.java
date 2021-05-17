package com.koreait.board7.cmt;

public class CmtVO {
	private int icmt;
	private int iuser;
	private int iboard;
	private String cmt;
	private String regdt;
	private int likecnt;
	private int dislike;
	private String uid;
	
	CmtVO() {}
	CmtVO(int iuser, int iboard, String cmt) {
		this.iuser = iuser;
		this.iboard = iboard;
		this.cmt = cmt;
	}
	
	public int getIcmt() {
		return icmt;
	}
	public void setIcmt(int icmt) {
		this.icmt = icmt;
	}
	public int getIuser() {
		return iuser;
	}
	public void setIuser(int iuser) {
		this.iuser = iuser;
	}
	public int getIboard() {
		return iboard;
	}
	public void setIboard(int iboard) {
		this.iboard = iboard;
	}
	public String getCmt() {
		return cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
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
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
}
