package com.course.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;


//@Controller
//@ResponseBody
@RestController
public class RestfulController {
	
	@Operation(tags = {"測試TAG", "測試TAG2"} , summary = "我是比較詳細的資料" , description = "我是描述")
	@GetMapping("/hello")
	// @ResponseBody
	public String hello() {
		return "hello";
	}
	
	@Operation(tags = "測試TAG2", summary= "我是比較詳細的資料", description="我是描述")
	@GetMapping("/hello2")
	// @ResponseBody
	public String hello2() {
		return "hello2";
	}
}
