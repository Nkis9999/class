package com.course.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class UsersEntity {
	
	@Id
	private Integer id;
	private String username;
	private String password;
	private String email;
	private String imgName;
	
}
