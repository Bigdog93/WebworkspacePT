package com.koreait.board9.board;

public class BoardDTO { // DAO에게 보내는 파라미터로 쓸 친구
	private int startIdx;
	private int recordCnt;
	private int searchType;
	private String searchText;
	private int iboard;
	private int iuser;
	public BoardDTO() {}
	public BoardDTO(int startIdx, int recordCnt) {
		super();
		this.startIdx = startIdx;
		this.recordCnt = recordCnt;
	}
	public int getStartIdx() {
		return startIdx;
	}
	public void setStartIdx(int startIdx) {
		this.startIdx = startIdx;
	}
	public int getRecordCnt() {
		return recordCnt;
	}
	public void setRecordCnt(int recordCnt) {
		this.recordCnt = recordCnt;
	}
	public int getSearchType() {
		return searchType;
	}
	public void setSearchType(int searchType) {
		this.searchType = searchType;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
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
}
