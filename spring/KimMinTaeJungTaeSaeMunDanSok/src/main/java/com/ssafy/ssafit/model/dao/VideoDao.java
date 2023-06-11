package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Video;

public interface VideoDao {
	
	//영상 다 가져오기
	public List<Video> selectAllVideo();
	
	//파트별 영상 가져오기
	public List<Video> selectPartVideo(String part);
	
	//특정 영상 가져오기
	public Video selectVideo(String videoId);
}
