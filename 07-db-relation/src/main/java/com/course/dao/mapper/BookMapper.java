package com.course.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.course.dto.BookDto;

@Mapper
public interface BookMapper {
	
	@Insert("INSERT INTO BOOK (NAME, AUTHOR, IMG_NAME, BUY_DATE) VALUES (#{name}, #{author}, #{imgName}, #{buyDate})")
	void insertBook(BookDto dto);
	
	void updateBook(BookDto dto);
	
	void deleteBook(Long id);
	
}
