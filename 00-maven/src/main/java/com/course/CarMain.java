package com.course;

import com.course.model.KiaEngine;
import com.course.model.Toyota;

public class CarMain {

	public static void main(String[] args) {
//		Toyota toyota = new Toyota(new ToyotaEngine());
		Toyota toyota = new Toyota(new KiaEngine());
		toyota.move();

	}

}
