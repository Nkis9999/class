package com.course.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.course.model.UserVo;

@Controller
public class AppController {

	private static final List<UserVo> userList = new ArrayList<>();
	
    static {
    	userList.add(new UserVo(1, "芙莉蓮", "111", "aaa@aaa.com"));
    	userList.add(new UserVo(2, "賽倫", "222", "bbb@bbb.com"));
    	userList.add(new UserVo(3, "星野愛", "333", "ccc@ccc.com"));
    }
    
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("title", "<span style=\"color:DodgerBlue;\">去唱卡拉ＯＫ吧</span>");
		
		model.addAttribute("title2", "<script>alert('你被攻擊了')</script>");
		
		model.addAttribute("param1", "半邊天");
		
		model.addAttribute("param2", "福利蓮");
		
		model.addAttribute("users", userList);
		
		model.addAttribute("isLogin", true);
		
		model.addAttribute("username", "Kitty");
		
		String name = "Kitty3";
		String usernameDisp = "";
		switch (name) {
		case "Kitty":
			usernameDisp = "佛殺凱蒂貓";
			break;
		case "Snoopy":
			usernameDisp = "史奴比";
			break;
		default:
			usernameDisp = "其他";
		}
		
		model.addAttribute("usernameDisp", usernameDisp);
		
		model.addAttribute("imageName", "iPhone17_w.jpg");
		return "app";
	}
	
	@GetMapping("/book")
	public String toBook() {
		return "book";
	}
	
	@GetMapping("/book/{id}")
	public String toBookPathVariable(@PathVariable Integer id) {
		System.out.println("ID:" + id);
		return "book";
	}
	
	@GetMapping("/books")
	public String toBookRequestParam(Integer page, String keyword) {
		System.out.println("page:" + page);
		System.out.println("keyword:" + keyword);
		return "book";
	}
	
	public String test() {
		String t = """
				
				""";
		

		return t;
	}
}
