package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.VideoDao;
import com.ssafy.ssafit.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	private VideoDao vDao;

	public List<Video> getVideoList() {
		return vDao.selectAllVideo();
	}

	public List<Video> getPartList(String part) {
		return vDao.selectPartVideo(part);
	}

	public Video getVideo(String videoId) {
		return vDao.selectVideo(videoId);
	}

}
