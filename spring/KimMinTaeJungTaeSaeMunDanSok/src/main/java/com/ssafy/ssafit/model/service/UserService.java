package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Rank;
import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.dto.UserRecord;

public interface UserService {

	User getUser(User user);

	int regist(User user);

	UserRecord getRecord(UserRecord userRecord);

	int setRecord(UserRecord userRecord);

	int getDay(User user);

	int getLongest(User user);

	int getTotalTime(User user);

	int getTotalDay(User user);

	List<Rank> getTopTen();


}
