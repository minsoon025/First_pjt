package com.ssafy.ssafit.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.dto.UserRecord;
import com.ssafy.ssafit.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api(tags = "유저 컨트롤러")
@CrossOrigin("*")
public class UserController {
	static HttpHeaders headers = new HttpHeaders();
	static {
		headers.add("Content-Type", "text/plain;charset=UTF-8");
	}
	
	@Autowired
	private UserService uService;
	
	@ApiOperation(value = "로그인 정보  확인", notes = "")
	@GetMapping("/login")
	public ResponseEntity<?> login(User user) {
		User u = uService.getUser(user); // user.id가 일치하는 계정 반환
		
		if(u == null) // 계정 없음
			return new ResponseEntity<String>("계정이 존재하지 않습니다.", headers, HttpStatus.BAD_REQUEST);
		else { //계정 있음
			// 비밀번호 불일치
			if(!u.getPassword().equals(user.getPassword()))
				return new ResponseEntity<String>("비밀번호를 다시 확인하세요.", headers, HttpStatus.BAD_REQUEST);
			// 일치
			else return new ResponseEntity<User>(u, HttpStatus.OK);
		}
	}
	@ApiOperation(value = "신규 회원 등록", notes = "")
	@PostMapping("/regist")
	public ResponseEntity<?> regist(User user) {
		int result = uService.regist(user);
		if(result == 0)
			return new ResponseEntity<String>("오류.", headers, HttpStatus.BAD_REQUEST);
		else if(result == -1)
			return new ResponseEntity<String>("이미 존재하는 아이디 입니다.", headers, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
	
	
	// 운동량기록 관련 
	@ApiOperation(value="유저의 운동 기록 가져오기, 없으면 만들고 가져오기")
	@GetMapping("/record")
	public ResponseEntity<?> getRecord(UserRecord userRecord) {
		userRecord.setDate(LocalDate.now()+"");
		UserRecord ur = uService.getRecord(userRecord);
		if(ur == null)
			return new ResponseEntity<String>("오류.", headers, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<UserRecord>(ur, HttpStatus.CREATED);
	}
	
	@ApiOperation(value="유저의 운동 기록 업데이트")
	@PutMapping("/record")
	public ResponseEntity<?> setRecord(UserRecord userRecord) {
		userRecord.setDate(LocalDate.now()+"");
		int result = uService.setRecord(userRecord);
		if(result == 0)
			return new ResponseEntity<String>("오류.", headers, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<UserRecord>(userRecord, HttpStatus.CREATED);
	}
	
}
