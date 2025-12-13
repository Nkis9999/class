package com.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@GetMapping("/")
	public String home() {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginAction(@RequestParam String username, @RequestParam String password) {
		if (username.equals("aaa") && password.equals("111")) {
			return "loginSuccess";
		} else {
			return "loginFail";
		}
	}
}
