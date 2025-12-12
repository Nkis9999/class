package com.course.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class LifeCycleBean implements InitializingBean, DisposableBean {

	private ToyotaEngine engine;
	
	public LifeCycleBean() {
		System.out.println("1. LifeCycleBean 建構");
	}
	
	@Autowired
	public void setEngine(ToyotaEngine engine) {
		System.out.println("1.5 setEngine...");
		this.engine = engine;
	}

	@PostConstruct
	public void init() {
		System.out.println("2. LifeCycleBean init");
	}
	
	@PreDestroy
	public void cleanUp() {
		System.out.println("3. LifeCycleBean cleanUp");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("3.5 destroy");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("2.5 afterPropertiesSet");
		
	}
}
