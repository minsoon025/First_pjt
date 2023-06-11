package com.ssafy.ssafit.model.dto;

public class UserRecord {
	private String user_id;
	private String date;
	private int time;
	private int th;
	
	public UserRecord() { }
	public UserRecord(String user_id, int time, String date, int th) {
		this.user_id = user_id;
		this.time = time;
		this.date = date;
		this.th = th;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getExTime() {
		return time;
	}
	public void setExTime(int time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTh() {
		return th;
	}
	public void setTh(int th) {
		this.th = th;
	}
}
