package com.course.dao;

import java.util.List;

import com.course.dto.BookDto;
import com.course.dto.StoreDto;

public interface BookDao {

	// Create
	void insertBook(BookDto dto);
	
	// Read
	List<BookDto> findAll();
	
	// Update
	void updateBook(BookDto dto);
	
	// Delete
	void deleteBookById(Long id);
	
	List<StoreDto> findAllStore();

	List<StoreDto> findAllStoreWithData();

	List<BookDto> findInventoryByCode(String code);
}
