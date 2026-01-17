package com.course.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.course.dao.BookDao;
import com.course.dto.BookDto;
import com.course.dto.StoreDto;
import com.course.model.StoreRowMapper;

@Repository
public class BookJdbcDaoImpl implements BookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertBook(BookDto dto) {
		String sql = "INSERT INTO BOOK (NAME, AUTHOR, IMG_NAME, BUY_DATE) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, dto.getName(), dto.getAuthor(), dto.getImgName(), dto.getBuyDate());
	}

	@Override
	public void updateBook(BookDto dto) {
		String sql = "UPDATE BOOK SET NAME = ?, AUTHOR = ? , BUY_DATE = ? , IMG_NAME= ? WHERE ID = ?";
		jdbcTemplate.update(sql, dto.getName(), dto.getAuthor(), dto.getBuyDate(), dto.getImgName(), dto.getId());
	}

	@Override
	public void deleteBookById(Long id) {
		String sql = "DELETE FROM BOOK WHERE ID = ?";
		jdbcTemplate.update(sql, id);
	}
	
	@Override
	public List<BookDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StoreDto> findAllStore() {
		String sql = "SELECT * FROM STORE";
		// Interface RowMapper
		// new RowMapper() (X) -> new StoreRowMapper()
		return jdbcTemplate.query(sql, new StoreRowMapper());
	}
	
	@Override
	public List<StoreDto> findAllStoreWithData() {
		// String sql = "SELECT * FROM STORE JOIN STORE_PROFILE F ON F.STORE_ID = S.ID";
		// StringBuffer
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT ");
		sb.append(" S.ID S_ID, ");
		sb.append(" S.CODE, ");
		sb.append(" S.NAME, ");
		sb.append(" F.ADDRESS ");
		sb.append(" FROM STORE S ");
		sb.append(" JOIN STORE_PROFILE F ON F.STORE_ID = S.ID ");

		RowMapper<StoreDto> storeRowMapper = new RowMapper<>() {
			// 匿名類別
			@Override
			public StoreDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				StoreDto dto = new StoreDto();
				dto.setId(rs.getLong("S_ID"));
				dto.setCode(rs.getString("CODE"));
				dto.setName(rs.getString("NAME"));
				dto.setAddress(rs.getString("ADDRESS"));
				return dto;
			}
		};
		return jdbcTemplate.query(sb.toString(), storeRowMapper);
	}

}
