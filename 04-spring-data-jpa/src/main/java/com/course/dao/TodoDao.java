package com.course.dao;

import java.util.List;

import com.course.entity.TodoEntity;

public interface TodoDao {
	List<TodoEntity> findAll();
	
	TodoEntity findById(Integer id);
	
	void deleteById(Integer id);
}
