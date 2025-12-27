package com.course.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.entity.TodoEntity;
import com.course.model.TodoVo;
import com.course.repository.TodoRepository;

import jakarta.transaction.Transactional;

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
	
	public List<TodoEntity> findByDuedateBetween(String startDateStr, String endDateStr) {
		
		Date startDate = genQueryDate(startDateStr, false);
		
		Date endDate = genQueryDate(endDateStr, true);

		return todoRepository.findByDuedateBetween(startDate, endDate);
	}
	
	public List<TodoEntity> findByTitleStartingWithOrderByDuedateDesc(String title) {
		return todoRepository.findByTitleStartingWithOrderByDuedate(title);
//		return todoRepository.findByTitleStartingWithOrderByDuedateDesc(title);
	}
	
	private Date genQueryDate(String dateStr, boolean isEndDate) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date date = null;
	    try {
	        if (isEndDate) {
	            date = dateFormat.parse(dateStr + " 23:59:59");
	        } else {
	            date = dateFormat.parse(dateStr + " 00:00:00");				
	        }
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    return date;
	}
	
	/**
	 * 依狀態查詢
	 * @param status
	 * @return
	 */
	public List<TodoEntity> findByQuery(Integer status) {
		// return todoRepository.findByQuery(status);
		// return todoRepository.findByQuery2(status);
		return todoRepository.findByQuery2("買菜", status);
	}
	
	public List<TodoEntity> findByNativeQuery(Integer status) {
		return todoRepository.findByNativeQuery(status);
	}
	
	public void insertTodo(TodoVo todoVo) {
		
		TodoEntity entity =  new TodoEntity();
		entity.setTitle(todoVo.getTitle());
		entity.setDuedate(genQueryDate(todoVo.getDuedate(),false));
		entity.setStatus(todoVo.getStatus());

		System.out.println("======  Before  ========" + entity.getId());
		
		// TodoEntity
		entity = todoRepository.save(entity);
		System.out.println(entity.getId());
	}
	
	public void updateTodo(TodoVo todoVo) {
		// 要更新哪一筆資料?
		Integer id = todoVo.getId();
		Optional<TodoEntity> op = todoRepository.findById(id);
		if (op.isPresent()) {
			TodoEntity entity = op.get();
			entity.setTitle(todoVo.getTitle());
			entity.setDuedate(genQueryDate(todoVo.getDuedate(),false));
			entity.setStatus(todoVo.getStatus());
			todoRepository.save(entity);
		}
	}
	
	public void deleteTodo(Integer id) {
		todoRepository.deleteById(id);
	}
	
	public void updateQuery(String title, Integer id) {
		todoRepository.updateByQuery(title, id);
	}
	
	public void insertTodoQuery(TodoVo todoVo) {

		// TodoEntity
		todoRepository.insertByQuery(todoVo.getTitle(), genQueryDate(todoVo.getDuedate(),false), todoVo.getStatus());
	}
	
	@Transactional
	public void deleteByStatus(Integer id) {
		// todoRepository.deleteAll();
		todoRepository.deleteByStatus(id);
	}
}
