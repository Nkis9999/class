package com.course;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.course.config.AppConfig;
import com.course.model.Toyota;

public class AppMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext("com.course.config");

		for (String name : ctx.getBeanDefinitionNames()) {
			System.out.println(name);
		}
		
		Toyota car = ctx.getBean("toyota", Toyota.class);
		car.move();
	}

}
