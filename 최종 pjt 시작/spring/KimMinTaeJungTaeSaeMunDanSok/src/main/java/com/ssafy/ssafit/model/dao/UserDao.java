package com.ssafy.ssafit.model.dao;

import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.dto.UserRecord;

public interface UserDao {

	User selectUser(String id);

	int insertUser(User user);

	UserRecord selectRecord(UserRecord userRecord);

	int insertRecord(UserRecord ur);

	int updateRecord(UserRecord userRecord);


}
