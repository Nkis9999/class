package com.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.entity.TodoEntity;
import com.course.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	/**
	 * 查詢全部
	 * @return
	 */
	public List<TodoEntity> getAllTodo() {
		return todoRepository.findAll();
	}
	
	/**
	 * 依狀態查詢
	 * @param status
	 * @return
	 */
	public List<TodoEntity> getTodoByStatus(Integer status) {
		return todoRepository.findByStatus(status);
	}
	
	/**
	 * 依名稱與狀態查詢
	 * @param title
	 * @param status
	 * @return
	 */
	public List<TodoEntity> getTodoByTitleAndStatus(String title, Integer status) {
		return todoRepository.findByTitleAndStatus(title, status);
	}
	
	public List<TodoEntity> getTodoByTitleLike(String title) {
		String keyword = "%" + title + "%";
		//return todoRepository.findByTitleLike(keyword);
		
		return todoRepository.findByTitleContaining(title);
	}
	
	
	public List<TodoEntity> getTodoByIdPeriod(Integer id) {
		return todoRepository.findByIdGreaterThan(id);
	}
}
