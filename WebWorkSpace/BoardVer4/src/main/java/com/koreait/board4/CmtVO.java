package com.koreait.board4;

public class CmtVO {
	private int iboard;
	private int icmt;
	private String cmtID;
	private String cmt;
	private String cmt_regdt;
	
	CmtVO() {}
	
	CmtVO(int iboard, String cmtID, String cmt) {
		this(iboard, 0, cmtID, cmt, null);
	}
	
	CmtVO(int iboard, int icmt, String cmtID, String cmt, String cmt_regdt) {
		this.iboard = iboard;
		this.icmt = icmt;
		this.cmtID = cmtID;
		this.cmt = cmt;
		this.cmt_regdt = cmt_regdt;
	}
	
	public int getIboard() {
		return iboard;
	}
	public void setIboard(int iboard) {
		this.iboard = iboard;
	}
	public int getIcmt() {
		return icmt;
	}

	public void setIcmt(int icmt) {
		this.icmt = icmt;
	}

	public String getCmtID() {
		return cmtID;
	}
	public void setCmtID(String cmtID) {
		this.cmtID = cmtID;
	}
	public String getCmt() {
		return cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
	public String getCmt_regdt() {
		return cmt_regdt;
	}
	public void setCmt_regdt(String cmt_regdt) {
		this.cmt_regdt = cmt_regdt;
	}
}
