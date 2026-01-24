package com.course.dto;

import java.util.List;

import lombok.Data;

@Data
public class StoreDto {

	private Long id;
	
	private String code;
	
	private String name;
	
	private String address;
	
	private List<String> codes;
}
