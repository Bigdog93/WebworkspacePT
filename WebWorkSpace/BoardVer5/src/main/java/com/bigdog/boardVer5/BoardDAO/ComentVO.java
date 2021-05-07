package com.bigdog.boardVer5.BoardDAO;

public class ComentVO {
	private int iboard;
	private int icmt;
	private String cmt;
	private String cmtID;
	private String cmt_regdt;
	private int likecnt;
	private int dislike;
	
	public ComentVO() {}
	
	public ComentVO(int icmt) {
		this.icmt = icmt;
	}
	
	public ComentVO(int iboard, String cmt, String cmtID) {
		this(iboard, 0, cmt, cmtID, null, 0, 0);
	}
	
	public ComentVO(int iboard, int icmt, String cmt, String cmtID, String cmt_regdt, int likecnt, int dislike) {
		this.iboard = iboard;
		this.icmt = icmt;
		this.cmt = cmt;
		this.cmtID = cmtID;
		this.cmt_regdt = cmt_regdt;
		this.likecnt = likecnt;
		this.dislike = dislike;
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
	public String getCmt() {
		return cmt;
	}
	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
	public String getCmtID() {
		return cmtID;
	}
	public void setCmtID(String cmtID) {
		this.cmtID = cmtID;
	}
	public String getCmt_regdt() {
		return cmt_regdt;
	}
	public void setCmt_regdt(String cmt_regdt) {
		this.cmt_regdt = cmt_regdt;
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
