package com.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/stores")
	public ResponseEntity<String> getStores() {
		bookService.findAllStore();
		return ResponseEntity.ok("OK");
	}
	
	@GetMapping("/books")
	public ResponseEntity<String> getBooks() {
		bookService.findAllBook();
		return ResponseEntity.ok("OK");
	}
}
