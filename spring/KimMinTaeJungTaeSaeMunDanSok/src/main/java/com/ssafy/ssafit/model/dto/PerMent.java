package com.ssafy.ssafit.model.dto;

public class PerMent {
	private int ment_id;
	private int level;
	private String ment;
	
	public PerMent() {}
	public PerMent(int ment_id, int level, String ment) {
		this.ment_id = ment_id;
		this.level = level;
		this.ment = ment;
	}
	public int getMent_id() {
		return ment_id;
	}
	public void setMent_id(int ment_id) {
		this.ment_id = ment_id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getMent() {
		return ment;
	}
	public void setMent(String ment) {
		this.ment = ment;
	}
	
}
