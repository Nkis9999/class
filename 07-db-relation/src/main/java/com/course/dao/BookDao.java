package com.course.dao;

import java.util.List;

import com.course.dto.BookDto;

public interface BookDao {

	// Create
	void insertBook(BookDto dto);
	
	// Read
	List<BookDto> findAll();
	
	// Update
	void updateBook(BookDto dto);
	
	// Delete
	void deleteBookById(Long id);
}
