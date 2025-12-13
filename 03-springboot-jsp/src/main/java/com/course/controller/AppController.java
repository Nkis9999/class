package com.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// @RequestMapping("/api")
public class AppController {

	@RequestMapping("/")
	public String home() {
		return "index2";
	}
	// URL: /login
	// @RequestMapping(value = "/login", method = RequestMethod.GET)
//	@GetMapping("/login")
//	public String login() {
//		return "loginSuccess";
//	}
	
	// "?" 匹配一個字元
	// http://localhost:8080/pattern/home1, http://localhost:8080/pattern/home2
	@GetMapping("/pattern/home?")
	public String home1() {
	    return "home";
	}

	// "*" 匹配多個字元 
	// http://localhost:8080/pattern/home1, http://localhost:8080/pattern/home100
	@GetMapping("/pattern/home*")
	public String home2() {
	    return "home";
	}

	// "**" 匹配零個或多個路徑，路徑名稱任意
	// http://localhost:8080/pattern/home1, http://localhost:8080/pattern/home/abc
	@GetMapping("/pattern/**")
	public String home3() {
	    return "home";
	}
	
}
