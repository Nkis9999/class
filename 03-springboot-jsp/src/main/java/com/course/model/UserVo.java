package com.course.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserVo {
	
    private String nickname;
    
    private String phone;
    
    private String[] hobby;
    
    // 接收上傳物件
    private MultipartFile photo;
}
