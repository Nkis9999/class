package com.course.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
	
	public List<BookVo> getAllBook() {
		List<BookEntity> books = bookRepo.findAll();
		// Entity -> Vo
		
		return books.stream().map(entity -> convertToVo(entity)).collect(Collectors.toList());
		
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
	
	
	public BookVo convertToVo(BookEntity entity) {
		BookVo vo = new BookVo();
		vo.setId(entity.getId());
		vo.setName(entity.getName());
		vo.setAuthor(entity.getAuthor());
		vo.setBuyDate(parseDateToString(entity.getBuyDate()));
		vo.setImgName(entity.getImgName());
		return vo;
	}
	
	public String parseDateToString(Date date) {
	    // 定義日期格式
	   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	   // 將 Date 物件轉換為 String
	   return formatter.format(date);
	}
}
