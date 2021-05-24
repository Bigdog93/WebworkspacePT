package com.koreait.board9;

public class Sibum {
	String test = "";
	
	public Sibum append2(String str) {
		this.test = this.test + str;
		return this;
	}
	
	public void main() {
		Sibum sb = new Sibum();
		sb.append2("didi").append2("didi").append2("dd");
	}
}
