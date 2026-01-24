package com.course.service;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.course.dao.BookDao;
import com.course.dto.BookDto;
import com.course.dto.StoreDto;

@Service
public class BookService {

	@Autowired
	// @Qualifier("bookJdbcDaoImpl")
	@Qualifier("bookMyBatisDaoImpl")
	private BookDao bookDao;
	
	@Transactional
	public void addBook(BookDto dto) {
		
		// 複雜邏輯
		// ...
		bookDao.insertBook(dto);
		
		// 複雜邏輯....
	}
	
	public List<StoreDto> getStores() {
		// return bookDao.findAllStore();
		return bookDao.findAllStoreWithData();
	}
	
	public List<BookDto> getInventoryByCode(String code) {
		return bookDao.findInventoryByCode(code);
	}
	
	public void updateBook(BookDto dto) {
		bookDao.updateBook(dto);
		
	}

	public void deleteBookById(Long id) {
		bookDao.deleteBookById(id);
	}
	
	public void insertStore(StoreDto dto) {
		try {
			bookDao.insertStore(dto);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<BookDto> findAllBook() {
		return bookDao.findAll();
	}
}
