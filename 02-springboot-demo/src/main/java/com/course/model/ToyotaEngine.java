package com.course.model;

import org.springframework.stereotype.Component;

@Component
public class ToyotaEngine implements Engine {

	@Override
	public void start() {
		System.out.println("ToyotaEngine...");
	}


}
