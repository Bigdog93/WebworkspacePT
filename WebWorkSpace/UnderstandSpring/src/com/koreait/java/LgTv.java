package com.koreait.java;

public class LgTv extends Tv {

	/*
	is B (상속)
	has B (멤버필드 객체화)
	 */
	
	
	public LgTv(Speaker speaker) {
		super("LgTv", 100, 40, 50, speaker);
	}
	
}
