package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.dto.BookDto;
import com.course.dto.StoreDto;
import com.course.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping("/book")
	public void addBook(@RequestBody BookDto dto) {
		bookService.addBook(dto);
	}
	
	@GetMapping("/stores")
	public List<StoreDto> getStores() {
		return bookService.getStores();
	}
	
	@GetMapping("/inventory/code/{code}")
	public List<BookDto> getInventoryByCode(@PathVariable String code) {
		return bookService.getInventoryByCode(code);
	}
}
