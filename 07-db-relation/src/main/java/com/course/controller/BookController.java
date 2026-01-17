package com.course.controller;

import org.springframework.web.bind.annotation.RestController;

import com.course.service.BookService;

@RestController
public class BookController {
	
	private BookService bookService;
}
