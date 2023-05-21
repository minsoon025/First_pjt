package com.ssafy.ssafit.model.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.UserDao;
import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.dto.UserRecord;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao uDao;
	
	public User getUser(User user) { // user.id가 일치하는 계정 반환
		return uDao.selectUser(user.getId());
	}
	
	public int regist(User user) {
		if(uDao.selectUser(user.getId()) != null) // 이미 존재하는 아이디
			return -1;
		return uDao.insertUser(user);
	}

	public UserRecord getRecord(UserRecord userRecord) {
		UserRecord ur = uDao.selectRecord(userRecord);
		if(ur != null) return ur; //이미 오늘 기록 존재
		
		// 오늘 첫 로그인(기록 없음)
		ur = new UserRecord(userRecord.getUser_id(), 0, LocalDate.now()+"");
		if(uDao.insertRecord(ur) == 0) return null;
		return ur;
	}

	public int setRecord(UserRecord userRecord) {
		return uDao.updateRecord(userRecord);
	}
	
}
