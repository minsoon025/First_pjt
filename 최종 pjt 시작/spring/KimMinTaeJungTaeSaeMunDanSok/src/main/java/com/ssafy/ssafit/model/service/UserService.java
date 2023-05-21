package com.ssafy.ssafit.model.service;

import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.dto.UserRecord;

public interface UserService {

	User getUser(User user);

	int regist(User user);

	UserRecord getRecord(UserRecord userRecord);

	int setRecord(UserRecord userRecord);


}
