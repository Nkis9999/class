package com.course.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class kiaEngine implements Engine {

	@Override
	public void start() {
		System.out.println("kiaEngine...");
	}


}
