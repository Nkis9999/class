package com.course.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.entity.BookEntity;
import com.course.model.BookVo;
import com.course.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private BookServiceHelper helper;
	
	public List<BookVo> getAllBook() {
		List<BookEntity> books = bookRepo.findAll();
		// Entity -> Vo
		
		return books.stream().map(entity -> helper.convertToVo(entity)).collect(Collectors.toList());
		
//		List<BookVo> voList = new ArrayList<>();
//		for (BookEntity entity : books) {
//			BookVo vo = convertToVo(entity);
//			voList.add(vo);
//		}

//		return voList;
	}
	
	public void deleteBookById(Long id) {
		bookRepo.deleteById(id);
	}
	
	public void insertBook(BookVo book) {
		// 轉成 Entity
		BookEntity entity = new BookEntity();
		// 存進 DB
		entity.setName(book.getName());
		entity.setAuthor(book.getAuthor());
		entity.setBuyDate(helper.parseDate(book.getBuyDate()));
		entity.setImgName(book.getFile().getOriginalFilename());
		bookRepo.save(entity);
		
		try {
			helper.saveImage(book.getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public BookVo getBookById(Long id) {
		// Optional<BookEntity> opt = bookRepo.findById(id);
		BookEntity entity = bookRepo.findById(id).orElse(null);
		return helper.convertToVo(entity);
	}
	
	public void updateBook(BookVo book) {
		BookEntity entity = bookRepo.findById(book.getId()).orElse(null);
		if (!book.getName().isBlank()) {
			entity.setName(book.getName());
		}
		
		if (!book.getAuthor().isBlank()) {
			entity.setAuthor(book.getAuthor());
		}
		
		if (!book.getBuyDate().isBlank()) {
			entity.setBuyDate(helper.parseDate(book.getBuyDate()));
		}
		
		if (book.getFile() != null && !book.getFile().getOriginalFilename().isBlank()) {
			entity.setImgName(book.getFile().getOriginalFilename());
			try {
				helper.saveImage(book.getFile());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		bookRepo.save(entity);
	}
	
	public List<BookVo> getSearchBook(String keyword) {
		// LIKE %keyword%
		List<BookEntity> books = bookRepo.findByNameContaining(keyword);
		// Entity -> Vo
		
		return books.stream().map(entity -> helper.convertToVo(entity)).collect(Collectors.toList());

	}
}
