package com.ssafy.ssafit.model.dto;

public class Rank {
	private String id;
	private int level;
	private String longest;
	
	public Rank() {}

	public Rank(String id, int level, String longest) {
		super();
		this.id = id;
		this.level = level;
		this.longest = longest;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getLongest() {
		return longest;
	}

	public void setLongest(String longest) {
		this.longest = longest;
	}
	
}
