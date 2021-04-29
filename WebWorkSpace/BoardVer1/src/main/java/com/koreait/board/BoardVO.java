package com.koreait.board;

public class BoardVO { // 값을 전달하기 위한 오브젝트 (Value Object)
	// 데이터베이스의 자료와 1:1 mapping이 되게 할꺼얌
	
	private int iboard;
	private String title;
	private String ctnt;
	
	
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
	
	

}
