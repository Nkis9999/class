package com.course.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.course.model.Engine;
import com.course.model.Toyota;
import com.course.model.ToyotaEngine;

@Configuration
public class AppConfig {

	@Bean(name = {"Benz2" , "toyota"})
	public Toyota toyota(Engine engine) {
		return new Toyota(engine);
	}
	
	@Bean
	public ToyotaEngine toyotaEngine() {
		return new ToyotaEngine();
	}
}
