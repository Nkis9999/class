package com.course.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		return todoRepository.findByQuery(status);
	}
}
