package com.ssafy.ssafit.model.dto;

public class User {
	private String id;
	private String password;
	private String name;
	private int level;
	
	public User() {}
	public User(String id, String password, String name, int level) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.level = level;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
}
