package com.course;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.course.model.Toyota;

public class XmlMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		for (String name : ctx.getBeanDefinitionNames()) {
			System.out.println(name);
		}
		
		System.out.println("============================");
		
		Toyota car = (Toyota) ctx.getBean("toyota");
		car.move();
	}

}
