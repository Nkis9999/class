package com.course.service;

import org.springframework.stereotype.Service;

// @Component
@Service
public class LoginService {

	public boolean checkLogin(String username, String password) {
		if (username.equals("aaa") && password.equals("111")) {
			return true;
		} else {
			return false;
		}
	}
}
