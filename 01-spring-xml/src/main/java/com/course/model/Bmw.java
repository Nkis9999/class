package com.course.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Bmw {
	
	private Engine engine;
	
	
	@Autowired
	@Qualifier("toyotaEngine")
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Bmw(Engine engine) {
		this.engine = engine;
	}

	public void move() {
		engine.start();
		
		System.out.println("Bmw move!!");
	}
}
