package com.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.entity.BookEntity;
import com.course.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	public List<BookEntity> getAllBook() {
		List<BookEntity> books = bookRepo.findAll();
		return books;
	}
}
