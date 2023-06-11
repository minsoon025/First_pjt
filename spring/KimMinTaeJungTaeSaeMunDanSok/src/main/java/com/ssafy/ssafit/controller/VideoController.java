package com.ssafy.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Video;
import com.ssafy.ssafit.model.service.VideoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/video")
@Api(tags = "동영상 컨트롤러")
@CrossOrigin("*")
public class VideoController {
	static HttpHeaders headers = new HttpHeaders();
	static {
		headers.add("Content-Type", "text/plain;charset=UTF-8");
	}
	
	@Autowired
	private VideoService vService;
	
	@ApiOperation(value = "영상 전체 랜덤 조회", notes = "")
	@GetMapping("/")
	public ResponseEntity<?> videoList() {
		List<Video> list = vService.getVideoList();
		
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "영상 파트별 랜덤 조회", notes = "")
	@GetMapping("/{part}")
	public ResponseEntity<?> partList(@PathVariable String part) {
		List<Video> list = vService.getPartList(part);
		
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "특정 영상 선택", notes = "")
	@GetMapping("/play/{videoId}")
	public ResponseEntity<?> part(@PathVariable String videoId) {
		Video v = vService.getVideo(videoId);
		
		if(v == null)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Video>(v, HttpStatus.OK);
	}
	
	
}
