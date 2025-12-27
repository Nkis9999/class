package com.course.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.course.entity.TodoEntity;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {

	List<TodoEntity> findByTitle(String title);
	
	List<TodoEntity> findByStatus(Integer status);
	
	List<TodoEntity> findByTitleAndStatus(String title, Integer status);
	
	// SQL語句：select * from todo where title like '%關鍵字%'
	List<TodoEntity> findByTitleLike(String title);
	
	// SQL語句：select * from todo where title like '%關鍵字%'
	List<TodoEntity> findByTitleContaining(String title);

	// SQL語句：select * from todo where title like '關鍵字%'
	List<TodoEntity> findByTitleStartingWith(String title);

	// SQL語句：select * from todo where title like '%關鍵字'
	List<TodoEntity> findByTitleEndingWith(String title);
	
	// SQL語句：select * from todo where id > ?
	List<TodoEntity> findByIdGreaterThan(Integer id);

	// SQL語句：select * from todo where id <= ?
	List<TodoEntity> findByIdLessThanEqual(Integer id);
	
	List<TodoEntity> findByDuedateBetween(Date startDate, Date endDate);
	
	List<TodoEntity> findByIdAndTitleOrDuedateAndStatus(Integer id, String title, Date duedate, Integer status);
	
	// SQL語句：select * from todo order by duedate;
	List<TodoEntity> findAllByOrderByDuedate();
	
	// SQL語句：select * from todo where title like ? order by due_date desc;
	List<TodoEntity> findByTitleStartingWithOrderByDuedate(String title);
	
	// SQL語句：select * from todo where title like ? order by due_date desc;
	List<TodoEntity> findByTitleStartingWithOrderByDuedateDesc(String title);
	
	// select * from todo where status = 1;
	// JPQL
	@Query("SELECT T FROM TodoEntity T WHERE T.status = ?1")
	List<TodoEntity> findByQuery(Integer status);
	
	// Named Param
	@Query("SELECT T FROM TodoEntity T WHERE T.status = :s1 AND T.title = :t1")
	List<TodoEntity> findByQuery2(@Param("t1") String title, @Param("s1") Integer status);
	
	// @Query("SELECT T FROM TodoEntity T WHERE T.status = ?1")
		@Query(nativeQuery = true, value = "SELECT * FROM TODO T WHERE T.STATUS = ?1")
		List<TodoEntity> findByNativeQuery(Integer status);
	
}
