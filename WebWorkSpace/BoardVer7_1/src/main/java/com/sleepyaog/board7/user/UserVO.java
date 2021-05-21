package com.sleepyaog.board7.user;

public class UserVO {
	private int iuser;
	private String uid;
	private String upw;
	private String unm;
	private String gender;
	private String ph;
	
	public UserVO() {}
	
	public UserVO(String uid, String upw, String unm, String gender, String ph) {
		super();
		this.uid = uid;
		this.upw = upw;
		this.unm = unm;
		this.gender = gender;
		this.ph = ph;
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
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUnm() {
		return unm;
	}
	public void setUnm(String unm) {
		this.unm = unm;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
}
