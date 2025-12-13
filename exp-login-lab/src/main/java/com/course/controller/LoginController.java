package com.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@GetMapping("/")
	public String home() {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginAction(@RequestParam String username, @RequestParam String password) {
		// new LoginService();
		// if (username.equals("aaa") && password.equals("111")) {
		if (loginService.checkLogin(username, password)) {
			return "loginSuccess";
		} else {
			return "loginFail";
		}
	}
}
