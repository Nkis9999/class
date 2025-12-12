package com.course;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.course.config.AnnotationConfig;
import com.course.model.Benz;
import com.course.model.Bmw;
import com.course.model.LazyBean;
import com.course.model.SingletonBean;

public class AnnotationMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationConfig.class);
//		for (String name : ctx.getBeanDefinitionNames()) {
//			System.out.println(name);
//		}
		
		System.out.println("=========================");
		Benz car = ctx.getBean("benz" , Benz.class);
		car.move();
		
		System.out.println("=========================");
		Bmw car2 = ctx.getBean("bmw" , Bmw.class);
		car2.move();
		
		System.out.println("=========================");
		Benz c1 = ctx.getBean("benz" ,Benz.class);
		Benz c2 = ctx.getBean("benz" ,Benz.class);
		
		System.out.println("c1:"+c1);
		System.out.println("c2:"+c2);
		System.out.println(c1.equals(c2));
		
		System.out.println("=========================");
		SingletonBean sb1 = SingletonBean.getInstance();
		SingletonBean sb2 = SingletonBean.getInstance();
		System.out.println("sb1:"+sb1);
		System.out.println("sb2:"+sb2);
		System.out.println(sb1.equals(sb2));
		
		System.out.println("=========================");
		LazyBean lazyBean = ctx.getBean(LazyBean.class);
		lazyBean.show();
		
		
	}

}
