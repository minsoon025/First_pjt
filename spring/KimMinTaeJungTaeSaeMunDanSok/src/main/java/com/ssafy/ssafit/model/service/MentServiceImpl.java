package com.ssafy.ssafit.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.MentDao;
import com.ssafy.ssafit.model.dto.Ment;

@Service
public class MentServiceImpl implements MentService {
	
	@Autowired
	private MentDao mDao;
	
	public String getMent() {
		return mDao.selectMent();
	}

	public String getPerMent(float percent) {
		if(percent == 0)
			return mDao.selectPerMent(1);
		else if(0 < percent && percent <= 33)
			return mDao.selectPerMent(2);
		else if(33 < percent && percent <= 66)
			return mDao.selectPerMent(3);
		else if(66 < percent && percent < 100)
			return mDao.selectPerMent(4);
		else if(percent == 100)
			return mDao.selectPerMent(5);
		return null;
	}

}
