package com.course.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
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
//		Integer.parseInt("ABC");
		return bookDao.findAll();
	}

	public List<StoreDto> findStoreByCondition(StoreDto dto) {
		return bookDao.findStoreByCondition(dto);
	}

	public List<BookDto> findBookWithCategory() {
		return bookDao.findBookWithCategory();
	}

	public List<BookDto> findBookWithCategoryTest() {
		// 查詢所有書籍(不含分類)
		List<BookDto> result = new ArrayList<>();
		List<BookDto> books = bookDao.findAll();
		for (BookDto book : books) {
			// 取得書籍分類
			List<String> categories = null; // = bookDao.findCategoryByBookId(book.getId());
			book.setCategories(categories);
			result.add(book);
		}

		return result;
	}

	public List<StoreDto> findStoresInCode(StoreDto dto) {
		return bookDao.findStoresInCode(dto);
	}
}
