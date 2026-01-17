package com.course.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.course.dao.BookDao;
import com.course.dto.BookDto;

@Repository
public class BookJdbcDaoImpl implements BookDao{

	@Override
	public void insertBook(BookDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BookDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBook(BookDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBookById(Long id) {
		// TODO Auto-generated method stub
		
	}

}
