package com.course;

import com.course.model.User;
import com.course.model.User2;

public class LombokMain {

	public static void main(String[] args) {
		User user = new User();
//		user.setName("Hello Kitty");
		System.out.println(user);
		
		User2 user2 = new User2();
		System.out.println(user2);
	}

}
