package com.course.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.course.dto.BookDto;
import com.course.dto.StoreDto;

@Mapper
public interface BookMapper {

	@Insert("INSERT INTO BOOK (NAME, AUTHOR, IMG_NAME, BUY_DATE) VALUES (#{name}, #{author}, #{imgName}, #{buyDate})")
	Integer insertBook(BookDto dto);
	
	@Update("UPDATE BOOK SET NAME = #{name}, AUTHOR = #{author} WHERE ID = #{id}")
	Integer updateBook(BookDto dto);
	
	@Delete("DELETE FROM BOOK WHERE ID = #{id}")
	Integer deleteById(Long id);
	
	// 限定自增主鍵，如果是 sequence 不適用
	@Options(useGeneratedKeys = true, keyProperty = "id")
	@Insert("INSERT INTO STORE (CODE, NAME) VALUES (#{code}, #{name})")
	Integer insertStore(StoreDto dto);
	
	@Insert("INSERT INTO STORE_PROFILE (STORE_ID, ADDRESS) VALUES (#{id}, #{address})")
	Integer insertStoreProfile(StoreDto dto);
	
	@Select("SELECT * FROM BOOK")
	List<BookDto> findAllBook();
	
	List<BookDto> findAllBook2();
	
	Integer insertBookByXml(BookDto dto);
	
	Integer updateBookByXml(BookDto dto);
	
	Integer deleteByIdByXml(Long id);
	
	List<StoreDto> findStoreByXml(StoreDto dto);
}
