package com.course.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long>{

	List<BookEntity> findByNameContaining(String keyword);
	
	Page<BookEntity> findByNameContaining(String keyword, Pageable pageable);
	
}
