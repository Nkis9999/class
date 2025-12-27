package com.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.entity.TodoEntity;
import com.course.model.TodoVo;
import com.course.service.TodoService;

//@Controller
@RestController
public class TodoController {
	
	@Autowired
	private TodoService todoService;

	@GetMapping("/test")
	public String test() {
		return "TEST";
	}
	
	@GetMapping("/todo")
	public List<TodoEntity> getTodos() {
		List<TodoEntity> todos = todoService.getAllTodo();
		return todos;
	}
	
	@GetMapping("/todo/status/{status}")
	public List<TodoEntity> getByStatus(@PathVariable Integer status) {
		List<TodoEntity> todos = todoService.getTodoByStatus(status);
		return todos;
	}
	
	@GetMapping("/todo/title/{title}")
	public List<TodoEntity> getByTitleLike(@PathVariable String title) {
		List<TodoEntity> todos = todoService.getTodoByTitleLike(title);
		return todos;
	}
	
	@GetMapping("/todo/period/{id}")
	public List<TodoEntity> getByIdPeriod(@PathVariable Integer id) {
		List<TodoEntity> todos = todoService.getTodoByIdPeriod(id);
		return todos;
	}
	
	@GetMapping("/todo/duedate-between")
	public List<TodoEntity> getByIdPeriod(@RequestParam String startDate, @RequestParam String endDate) {
		List<TodoEntity> todos = todoService.findByDuedateBetween(startDate, endDate);
		return todos;
	}
	
	@GetMapping("/todo/title-order/{title}")
	public List<TodoEntity> getByTitleOrderBy(@PathVariable String title) {
		List<TodoEntity> todos = todoService.findByTitleStartingWithOrderByDuedateDesc(title);
		return todos;
	}
	
	@GetMapping("/todo/query/status/{status}")
	public List<TodoEntity> findByQuery(@PathVariable Integer status) {
		List<TodoEntity> todos = todoService.findByQuery(status);
		return todos;
	}
	
	@GetMapping("/todo/native-query/status/{status}")
	public List<TodoEntity> findByNativeQuery(@PathVariable Integer status) {
		List<TodoEntity> todos = todoService.findByNativeQuery(status);
		return todos;
	}
	
	@PostMapping("/todo")
	public void insertTodo(@RequestBody TodoVo todoVo) {
		todoService.insertTodo(todoVo);
	}
	
	@PostMapping("/todo/update")
	public void updateTodo(@RequestBody TodoVo todoVo) {
		todoService.updateTodo(todoVo);
	}
}
