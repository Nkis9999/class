package com.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//	@Controller
public class LoginController {
	 @RequestMapping(value = "/login")
	    public String login() {
	        return "loginSuccess";
	    }
}
