package com.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.entity.BookEntity;
import com.course.entity.StoreEntity;
import com.course.repository.BookRepository;
import com.course.repository.StoreRepository;

@Service
public class BookService {

	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<StoreEntity> findAllStore() {
		List<StoreEntity> stores = storeRepository.findAll();
		return null;
	}
	
	public List<BookEntity> findAllBook() {
		List<BookEntity> stores = bookRepository.findAll();
		return null;
	}
}
