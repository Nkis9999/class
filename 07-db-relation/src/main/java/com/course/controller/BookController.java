package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.dto.BookDto;
import com.course.dto.StoreDto;
import com.course.service.BookService;

import io.swagger.v3.oas.annotations.Operation;

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
	
	@Operation(summary = "更新書籍", description = "更新書籍")
	@PutMapping("/book")
	public void updateBook(@RequestBody BookDto dto) {
		bookService.updateBook(dto);
	}

	@Operation(summary = "刪除書籍", description = "刪除書籍")
	@DeleteMapping("/book/{id}")
	public void deleteBookById(@PathVariable Long id) {
		bookService.deleteBookById(id);
	}
	
	@Operation(summary = "新增門市", description = "新增門市")
	@PostMapping("/store")
	public void insertStore(@RequestBody StoreDto dto) {
		bookService.insertStore(dto);
	}
	
	@Operation(summary = "查詢所有書籍", description = "查詢所有書籍")
	@GetMapping("/books")
	public List<BookDto> getAllBook() {
		return bookService.findAllBook();
	}
	
	@PostMapping("/book-condition")
	public List<StoreDto> findStoreByCondition(@RequestBody StoreDto dto) {
		return bookService.findStoreByCondition(dto);
	}
	
	@Operation(summary = "查詢所有書籍(含分類)", description = "查詢所有書籍")
	@GetMapping("/book-category")
	public List<BookDto> findBookWithCategory() {
		return bookService.findBookWithCategory();
	}
	
	@PostMapping("/stores-codes")
	public List<StoreDto> findStoresInCode(@RequestBody StoreDto dto) {
		return bookService.findStoresInCode(dto);
	}
}
