package com.ssafy.ssafit.model.dto;

public class Ment {
	private int ment_id;
	private String ment;
	
	public Ment() {}
	public Ment(int ment_id, String ment) {
		this.ment_id = ment_id;
		this.ment = ment;
	}
	
	public int getMent_id() {
		return ment_id;
	}
	public void setMent_id(int ment_id) {
		this.ment_id = ment_id;
	}
	public String getMent() {
		return ment;
	}
	public void setMent(String ment) {
		this.ment = ment;
	}
	
}
