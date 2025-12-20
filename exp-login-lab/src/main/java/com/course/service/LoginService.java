package com.course.service;

import org.springframework.stereotype.Service;

import com.course.model.UserVo;

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
	
	public boolean registeUser(UserVo userVo) {
		System.out.println("Service:" + userVo);
		// 實際註冊行為
		
		// 註冊成功
		return true;

	}
}
