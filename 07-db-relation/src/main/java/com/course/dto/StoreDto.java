package com.course.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StoreDto {

	private Long id;
	
	@NotBlank
	private String code;
	
	@NotBlank
	private String name;
	
	private String address;
	
	private List<String> codes;
}
