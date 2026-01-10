package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.course.model.BookVo;
import com.course.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping("/login")
	public String login(String username, String password) {
		// TODO: 檢查是否登入成功
		return "loginSuccess";
	}
	
	@GetMapping("/toBookcase")
	public String toBookcase(Model model) {
		// 查詢 書籍列表
		List<BookVo> books = bookService.getAllBook();
		model.addAttribute("books", books);
		return "bookcase";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		bookService.deleteBookById(id);
		// 查詢 書籍列表
//		List<BookVo> books = bookService.getAllBook();
//		model.addAttribute("books", books);
//		return "bookcase";
		return "redirect:/toBookcase";
	}
	
	@GetMapping("toAddBookPage")
	public String toAddBook(Model model) {
		model.addAttribute("book", new BookVo());
		return "addBook";
	}
	
	@PostMapping("/book")
	public String addBook(@ModelAttribute("book") BookVo book) {
		bookService.insertBook(book);
		return "redirect:/toBookcase";
	}
}
