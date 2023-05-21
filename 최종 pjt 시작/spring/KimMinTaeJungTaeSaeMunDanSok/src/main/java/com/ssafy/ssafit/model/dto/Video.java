package com.ssafy.ssafit.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "비디오 다오 ", description = "영상 정보")
public class Video {
	private String youtube_id;
	private String title;
	private String descript;
	private String channel_name;
	private String b_part;
	private String s_part;
	private int length;
	
	public Video() { }
	public Video(String youtube_id, String title, String descript, String channel_name, String b_part, String s_part,
			int length) {
		this.youtube_id = youtube_id;
		this.title = title;
		this.descript = descript;
		this.channel_name = channel_name;
		this.b_part = b_part;
		this.s_part = s_part;
		this.length = length;
	}
	public String getYoutube_id() {
		return youtube_id;
	}
	public void setYoutube_id(String youtube_id) {
		this.youtube_id = youtube_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getChannel_name() {
		return channel_name;
	}
	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}
	public String getB_part() {
		return b_part;
	}
	public void setB_part(String b_part) {
		this.b_part = b_part;
	}
	public String getS_part() {
		return s_part;
	}
	public void setS_part(String s_part) {
		this.s_part = s_part;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
}
