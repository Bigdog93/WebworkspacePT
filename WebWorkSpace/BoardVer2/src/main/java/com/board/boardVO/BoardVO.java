package com.board.boardVO;

public class BoardVO {
	private int board_idx;
	private String title;
	private String ctnt;
	private int like;
	private int dislike;
	private int view;
	
	public BoardVO() {};
	public BoardVO(String title, String ctnt) {
		this.title = title;
		this.ctnt = ctnt;
		this.like = 0;
	}
	public void setBoard_idx(int idx) {
		this.board_idx = idx;
	}
	
	public int getBoard_idx() {
		return board_idx;
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

	public int getLike() {
		return like;
	}
	
	public void setLike() {
		this.like++;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public int getDislike() {
		return dislike;
	}
	
	public void setDislike() {
		this.dislike++;
	}

	public void setDislike(int dislike) {
		this.dislike = dislike;
	}
	public int getView() {
		return view;
	}

	public void setView() {
		this.view++;
	}
	
	public void setView(int view) {
		this.view = view;
	}

	
}
