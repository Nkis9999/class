package com.course.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.course.entity.UserEntity;

@Mapper
public interface UserMapper {

	@Select("SELECT USER_SEQ.NEXTVAL FROM DUAL")
	Long getUserSeq();
	
	@Insert("INSERT INTO USERS (ID, USERNAME, PASSWORD) VALUES (#{id}, #{username}, #{password})")
	Integer insertUser(UserEntity user);
}
