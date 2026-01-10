package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.entity.BookEntity;
import com.course.model.BookVo;
import com.course.service.BookService;
import com.course.service.UserService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public String login(String username, String password) {
		// TODO: 檢查是否登入成功
		boolean isLoginSuccess = userService.login(username, password);
		return "loginSuccess";
	}
	
	@ModelAttribute("username")
	public String getUsername() {
		return userService.getUsernameFromSession();
	}
	
	@GetMapping("/toBookcase")
	public String toBookcase(Model model) {
		// 查詢 書籍列表
		List<BookVo> books = bookService.getAllBook();
		
		// Page<BookEntity> page = bookService.getAllBookPage(1, 3);
		
		String username = userService.getUsernameFromSession();
		model.addAttribute("books", books);
		// model.addAttribute("username", username);
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
	
	@GetMapping("/toEditPage/{id}")
	public String toEditBook(@PathVariable("id") Long id, Model model) {
		BookVo book = bookService.getBookById(id);
		model.addAttribute("book", book);
		return "editBook";
	}
	
	@PostMapping("/update")
	public String updateBook(@ModelAttribute("book") BookVo book) {
		bookService.updateBook(book);
		return "redirect:/toBookcase";
	}
	
	@GetMapping("search")
	public String searchKeyword(@RequestParam("keyword") String keyword, Model model) {
		// 查詢
		List<BookVo> books = bookService.getSearchBook(keyword);
		model.addAttribute("books", books);
		return "bookcase";
		
	}
	
	@GetMapping("/books")
	public String listBooks(
	        @RequestParam(defaultValue = "0") Integer page,
	        @RequestParam(defaultValue = "4") Integer size,
	        @RequestParam(defaultValue = "") String keyword,
	        Model model) {

		Page<BookVo> bookPage = bookService.findBookListPaging(page, size, keyword);

	    model.addAttribute("bookPage", bookPage);
	    model.addAttribute("currentPage", page);
	    model.addAttribute("keyword", keyword);

	    return "bookcase2";
	}
	
}
