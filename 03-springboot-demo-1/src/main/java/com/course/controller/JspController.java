package com.course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class JspController {

	@GetMapping("/home")
	public String home() {
		return "home";
	}
	@PostMapping(value = "/traditionRequest")
	public String traditionRequest(HttpServletRequest req) {
	    // 取得QueryString的參數值
	    String username = req.getParameter("username");
	    String password = req.getParameter("password");
	    
	    System.out.println("USERNAME:" + username);
	    System.out.println("PWD:" + password);
	    req.setAttribute("user", username);
	    return "loginSuccess";
	}

	@PostMapping("/login")
	public String login(@RequestParam(name = "username2", required = false, defaultValue = "Hello Kitty") String username, @RequestParam(value = "password2") String password) {
		
	    System.out.println("USERNAME:" + username);
	    System.out.println("PWD:" + password);
		return "loginSuccess";
	}
	
	// @GetMapping("/TP/TP0005043/goodsDetail/TP00050430000466")
	@GetMapping("/TP/TP0005043/goodsDetail/{productCode}")
	public String test(@PathVariable String productCode) {
		System.out.println("productCode:" + productCode);
		return "loginSuccess";
	}
	

	//TP/TP0004325/goodsDetail/TP00043250000051
	@GetMapping("TP/TP0004325/goodsDetail/TP00043250000051")
	public String test2() {
		return "loginSuccess";
	}
}
