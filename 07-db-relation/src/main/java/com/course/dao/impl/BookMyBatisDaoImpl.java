package com.course.dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.course.dao.BookDao;
import com.course.dao.mapper.BookMapper;
import com.course.dto.BookDto;
import com.course.dto.StoreDto;

@Repository
public class BookMyBatisDaoImpl implements BookDao {

	@Autowired
	private BookMapper bookMapper;
	
	@Override
	public void insertBook(BookDto dto) {
		// bookMapper.insertBook(dto);
		bookMapper.insertBookByXml(dto);
	}

	@Override
	public List<BookDto> findAll() {
		// return bookMapper.findAllBook();
		return bookMapper.findAllBook2();
	}

	@Override
	public void updateBook(BookDto dto) {
		// bookMapper.updateBook(dto);
		bookMapper.updateBookByXml(dto);
	}

	@Override
	public void deleteBookById(Long id) {
		// bookMapper.deleteById(id);
		bookMapper.deleteByIdByXml(id);
	}

	@Override
	public List<StoreDto> findAllStore() {
		
		return null;
	}

	@Override
	public List<StoreDto> findAllStoreWithData() {
		
		return null;
	}

	@Override
	public List<BookDto> findInventoryByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	// @Transactional
	@Transactional(rollbackFor = {Exception.class})
	public void insertStore(StoreDto dto) throws FileNotFoundException {
		bookMapper.insertStore(dto);
		
		// 強制設計一個 Exception
		// Integer.parseInt("ABC");
		
		FileInputStream fis = new FileInputStream("aaaa.txt");
		bookMapper.insertStoreProfile(dto);
		
	}

	@Override
	public List<StoreDto> findStoreByCondition(StoreDto dto) {
		return bookMapper.findStoreByXml(dto);
	}

	@Override
	public List<BookDto> findBookWithCategory() {

		return bookMapper.findBookWithCategory();
	}

	@Override
	public List<StoreDto> findStoresInCode(StoreDto dto) {
		return bookMapper.findStoresInCode(dto);
	}
	
	

}
