package com.course.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.course.dto.StoreDto;

public class StoreRowMapper implements RowMapper<StoreDto> {

	@Override
	public StoreDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		StoreDto dto = new StoreDto();
		dto.setCode(rs.getString("CODE"));
		dto.setName(rs.getString("NAME"));
		return dto;
	}

}
