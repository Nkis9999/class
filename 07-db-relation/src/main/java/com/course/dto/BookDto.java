package com.course.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BookDto {
	
	private Long id;
	
	private String name;
	
	private String author;
	
	private Date buyDate;
	
	private String imgName;
	
	private String storeName;
	
	private Integer quantity;
	
	private String address;
	
	private String category;
	
	private List<String> categories;
	
	private List<StoreDto> stores;
	
}
