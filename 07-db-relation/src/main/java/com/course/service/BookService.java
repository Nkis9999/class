package com.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.course.dao.BookDao;

@Service
public class BookService {
	
	@Autowired
	@Qualifier("bookJdbcDaoImpl")
	private BookDao bookDao;
	
	public void addBook() {
		bookDao.insertBook(null);
	}

}
