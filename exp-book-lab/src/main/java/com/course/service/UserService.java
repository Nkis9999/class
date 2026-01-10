package com.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.model.UserSession;

@Service
public class UserService {

	@Autowired
	private UserSession userSession;
	
	public boolean login(String username, String password) {
		// 紀錄 Session 資料
		userSession.setUsername(username);
		return true;
	}
	
	public String getUsernameFromSession() {
		return userSession.getUsername();
	}
}
