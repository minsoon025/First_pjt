package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Video;

public interface VideoService {

	List<Video> getVideoList();

	List<Video> getPartList(String part);

	Video getVideo(String videoId);

}
