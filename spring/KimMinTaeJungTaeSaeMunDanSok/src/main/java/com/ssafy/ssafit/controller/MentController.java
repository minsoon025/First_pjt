package com.ssafy.ssafit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.service.MentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/ment")
@Api(tags = "멘트 컨트롤")
@CrossOrigin("*")
public class MentController {
	
	static HttpHeaders headers = new HttpHeaders();
	static {
		headers.add("Content-Type", "text/plain;charset=UTF-8");
	}
	
	@Autowired
	private MentService mService;
	
	@ApiOperation(value = "멘트 렌덤으로 하나 가져오기")
	@GetMapping("")
	public ResponseEntity<?> getMent() {
		String m = mService.getMent();
		return new ResponseEntity<String>(m, headers, HttpStatus.OK);
	}
	
	@ApiOperation(value = "운동량 별 (단계별) 멘트 렌덤으로 하나 가져오기")
	@GetMapping("/percent")
	public ResponseEntity<?> getPerMent(float percent) {
		String m = mService.getPerMent(percent);
		return new ResponseEntity<String>(m, headers, HttpStatus.OK);
	}
}
