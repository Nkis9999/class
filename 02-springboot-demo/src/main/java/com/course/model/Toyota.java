package com.course.model;

import org.springframework.stereotype.Component;

@Component
public class Toyota {
	
	private Engine engine;
	
	public Toyota(Engine engine) {
		this.engine = engine;
	}

	public void move() {
		engine.start();
		
		System.out.println("Toyota move!!");
	}
}
