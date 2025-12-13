package com.course.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.course.model.UserVo;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class JspController {
	
	private Logger logger = LoggerFactory.getLogger(JspController.class);

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
	public String login(@RequestParam(name = "username2", required = false, defaultValue = "Hello Kitty") String username, 
			@RequestParam(value = "password2") String password, Model model) {
		
	    System.out.println("USERNAME:" + username);
	    System.out.println("PWD:" + password);
	    model.addAttribute("user", "!!!! " + username + " !!!");
		return "loginSuccess";
	}
	
	// @GetMapping("/TP/TP0005043/goodsDetail/TP00050430000466")
	@GetMapping("/TP/{c1}/goodsDetail/{productCode}")
	public String pathVariable(@PathVariable String productCode, @PathVariable("c1") String categoryCode) {
		System.out.println("categoryCode:" + categoryCode);
		System.out.println("productCode:" + productCode);
		return "loginSuccess";
	}
	
	@GetMapping("/mv/{c1}/goodsDetail/{productCode}")
	public ModelAndView pathVariableMv(@PathVariable String productCode, @PathVariable("c1") String categoryCode) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", productCode);
		mv.setViewName("loginSuccess");
		System.out.println("categoryCode:" + categoryCode);
		System.out.println("productCode:" + productCode);
		return mv;
	}
	
	// 將正則表達式作為名稱為 "name" 的路徑變數進行匹配
	@GetMapping("/user/regex/{name:[a-zA-Z]+}")
	public String pathVariableRegex(@PathVariable("name") String username) {
		
		System.out.println("pathVariableRegex username:" + username);
	    return "loginSuccess";
	}
	
	@PostMapping("/hobby")
	public String hobby(@ModelAttribute UserVo user) {
		System.out.println("user:" + user);
		return "loginSuccess";
	}
	
	@ModelAttribute("companyName")
	public String getCompanyName() {
		return "三麗鷗";
	}
	
	@GetMapping("/testModel")
	public String testModel(Model model) {
		System.out.println("testModel:");
		model.addAttribute("petName", "Snoopy");
		model.addAttribute("petAddress", "中正路30號");
		model.addAttribute("petHobby", "Snoopy3");
		return "loginSuccess";
	}
	
	@PostMapping(value = "/upload")
	public String upload(@ModelAttribute UserVo userVo) {
		
		MultipartFile file = userVo.getPhoto();
		if (!file.isEmpty()) {
			System.out.println("檔案名稱：" + file.getOriginalFilename());
			System.out.println("大小：" + file.getSize());

			// 儲存檔案
			// Path path = Paths.get("C:\\Users\\student\\images\\" + file.getOriginalFilename());
			Path path = Paths.get("C:", "Users", "student", "images" ,file.getOriginalFilename());
			try {
				Files.copy(file.getInputStream(), path);
			} catch (IOException e) {
				logger.error("uploadUser IOException", e);
			}
		}
		    
		return "home";
	}
}
