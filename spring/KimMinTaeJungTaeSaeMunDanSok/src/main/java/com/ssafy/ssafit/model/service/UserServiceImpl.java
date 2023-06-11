package com.ssafy.ssafit.model.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.UserDao;
import com.ssafy.ssafit.model.dto.Rank;
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
		int result = uDao.insertUser(user);
		if(uDao.insertLongest(user) == 0) return -2;
		return result;
	}

	public UserRecord getRecord(UserRecord userRecord) {
		UserRecord ur = uDao.selectRecord(userRecord);
		if(ur != null) return ur; //이미 오늘 기록 존재
		
		// 오늘 첫 로그인(기록 없음)
		ur = new UserRecord(userRecord.getUser_id(), 0, LocalDate.now()+"", 0);
		
		if(uDao.insertRecord(ur) == 0) return null;
		return ur;
	}

	public int setRecord(UserRecord userRecord) {
		// 누적일 업데이트
		UserRecord yester = uDao.selectRecord(
				new UserRecord(userRecord.getUser_id(), 0, (LocalDate.now().minusDays(1))+"", 0));
		if(yester != null) { // 어제도 접속한 경우
			userRecord.setTh(yester.getTh()+1);
			
			if(userRecord.getTh() > uDao.selectLongest(userRecord.getUser_id())) {
				// 최장누적일 업데이트
				int result = uDao.updateLongest(userRecord);
				if(result == 0) return -2;
			}
		}
		else userRecord.setTh(1);
		return uDao.updateRecord(userRecord);
	}

	public int getDay(User user) {
		UserRecord ur = uDao.selectRecord(new UserRecord(user.getId(), 0, LocalDate.now()+"", 0));
		if(ur == null) return -11;
		return ur.getTh();
	}

	public int getLongest(User user) {
		return uDao.selectLongest(user.getId());
	}

	public int getTotalTime(User user) {
		return uDao.selectTotalTime(user);
	}

	public int getTotalDay(User user) {
		return uDao.selectTotalDay(user);
	}

	public List<Rank> getTopTen() {
		return uDao.selectTopTen();
	}
	
}
