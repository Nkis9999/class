package com.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.model.UserSession;

import jakarta.servlet.http.HttpSession;

@Service
public class UserService {

	@Autowired
	private UserSession userSession;

	@Autowired
	private HttpSession httpSession;

	public boolean login(String username, String password) {
		// 紀錄 Session 資料
		userSession.setUsername(username);
		return true;
	}

	public String getUsernameFromSession() {
		return userSession.getUsername();
	}

	public void logout() {
		// userSession.setUsername("");
		// userSession.setUsername(null);
		// 把 Session 清除
		httpSession.invalidate();
	}
}
