package com.course.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookVo {
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String author;
	
	private String imgName;

}
