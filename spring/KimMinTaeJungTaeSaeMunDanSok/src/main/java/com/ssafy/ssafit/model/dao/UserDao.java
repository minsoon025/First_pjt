package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Rank;
import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.dto.UserRecord;

public interface UserDao {

	User selectUser(String id);

	int insertUser(User user);

	UserRecord selectRecord(UserRecord userRecord);

	int insertRecord(UserRecord ur);

	int updateRecord(UserRecord userRecord);

	int insertLongest(User user);

	int selectLongest(String user_id);

	int updateLongest(UserRecord userRecord);

	int selectTotalTime(User user);

	int selectTotalDay(User user);

	List<Rank> selectTopTen();

}
