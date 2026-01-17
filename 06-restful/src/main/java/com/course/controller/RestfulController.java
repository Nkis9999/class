package com.course.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.course.model.ApiResponse;
import com.course.model.User;

import io.swagger.v3.oas.annotations.Operation;

//@Controller
//@ResponseBody
@RestController
@CrossOrigin("http://127.0.0.1:5500/")
public class RestfulController {

	@Operation(tags = {"測試TAG", "測試TAG2"}, summary= "你好", description="我是描述")
	@GetMapping("/hello")
	// @ResponseBody
	public String hello() {
		return "hello";
	}
	
	@Operation(tags = {"測試TAG"}, summary= "ResponseEntity", description="我是描述")
	@GetMapping("/hello-ResponseEntity")
	public ResponseEntity<String> helloEntity() {
		return ResponseEntity.ok("hello");
	}
	
	@Operation(tags = {"測試TAG"}, summary= "not-found")
	@GetMapping("/not-found")
	public ResponseEntity<String> notFound() {
	    return new ResponseEntity<>("404找不到啦～", HttpStatus.REQUEST_TIMEOUT);
	}
	
	@Operation(summary = "取得使用者-自定義 ApiResponse", description = "取得使用者詳細資料", tags = "使用者")
	@GetMapping("/user/wrap")
	public ApiResponse<List<User>> getUsersWrapWithApiResponse() {
		List<User> users = null;
		return ApiResponse.error("401", "我也不知道發生什麼錯", users);
	}
	
	@Operation(tags = "測試TAG2", summary= "HELLO 你好嗎?", description="我是描述")
	@GetMapping("/hello2")
	public String hello2() {
		return "hello2";
	}
	
	@Operation(tags = "使用者", summary= "查詢所有使用者", description="查詢所有使用者")
	@GetMapping("/users")
	public String getAllUser() {
		return "你成功囉";
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
	@PostMapping("/user-RequestBody")
	public String addUserRequestBody(@RequestBody User user) {
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
	public String updateUserSomeData(@RequestBody User user) {
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
