package com.course.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.model.User;

import io.swagger.v3.oas.annotations.Operation;

//@Controller
//@ResponseBody
@RestController
public class RestfulController {

	@Operation(tags = {"測試TAG", "測試TAG2"}, summary= "你好", description="我是描述")
	@GetMapping("/hello")
	// @ResponseBody
	public String hello() {
		return "hello";
	}
	
	@Operation(tags = "測試TAG2", summary= "HELLO 你好嗎?", description="我是描述")
	@GetMapping("/hello2")
	public String hello2() {
		return "hello2";
	}
	
	@Operation(tags = "使用者", summary= "查詢所有使用者", description="查詢所有使用者")
	@GetMapping("/users")
	public String getAllUser() {
		return null;
	}
	
	@Operation(tags = "使用者", summary= "查詢單一使用者", description="查詢單一使用者")
	@GetMapping("/user/{id}")
	public String getUserById(@PathVariable Long id) {
		return null;
	}
	
	@Operation(tags = "使用者", summary= "新增使用者@ModelAttribute", description="新增使用者")
	@PostMapping("/user-ModelAttribute")
	public String addUserModelAttribute(@ModelAttribute User user) {
		return null;
	}
	
	@Operation(tags = "使用者", summary= "新增使用者@RequestBody", description="新增使用者")
	@PostMapping("/user-ReqestBody")
	public String addUserReqestBody(@RequestBody User user) {
		return null;
	}
	
	@Operation(tags = "使用者", summary= "刪除使用者", description="刪除使用者")
	@DeleteMapping("/user/{id}")
	public String deleteByID(@PathVariable Long id) {
		return null;
	}
	
	@Operation(tags = "使用者", summary= "更新使用者全部資料", description="更新使用者全部資料")
	@PutMapping("/user")
	public String updateUserAllData(@RequestBody User user) {
		return null;
	}
	
	@Operation(tags = "使用者", summary= "更新使用者部分資料", description="更新使用者部分資料")
	@PatchMapping("/user")
	public String updateUserSomeeData(@RequestBody User user) {
		return null;
	}
	
	@RequestMapping("/users-test")
	public String getAllUserTest() {
		return null;
	}
	
	@Operation(tags = "使用者", summary= "依照名稱查詢使用者", description="依照名稱查詢使用者")
	@GetMapping("/user/name")
	public String getUserByName(@RequestParam String name) {
		return null;
	}
}
