package com.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.course.dao.BookDao;
import com.course.dto.BookDto;
import com.course.dto.StoreDto;

@Service
public class BookService {

	@Autowired
	@Qualifier("bookJdbcDaoImpl")
	private BookDao bookDao;
	
	public void addBook(BookDto dto) {
		bookDao.insertBook(dto);
	}
	
	public List<StoreDto> getStores() {
		// return bookDao.findAllStore();
		return bookDao.findAllStoreWithData();
	}
	
	public List<BookDto> getInventoryByCode(String code) {
		return bookDao.findInventoryByCode(code);
	}
}
