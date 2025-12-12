package com.course.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("singleton")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Benz {
	
	private Engine engine;
	
//	@Autowired
	public Benz(@Qualifier("kiaEngine") Engine engine) {
		this.engine = engine;
	}

	public void move() {
		engine.start();
		
		System.out.println("Benz move!!");
	}
}
