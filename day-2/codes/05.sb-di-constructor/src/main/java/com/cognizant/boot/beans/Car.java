package com.cognizant.boot.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	private Engine engine;
	
	public Car() {
		super();
		System.out.println("Car :: Constructor");
	}
	
	@Autowired
	public Car(Engine engine) {
		System.out.println("Car :: One Argument Constructor");
		this.engine = engine;
	}

	public void startJourney() {
		boolean engineStatus = engine.startEngine();

		if (engineStatus) {
			System.out.println("Happy Journey!!");
		} else {
			System.err.println("Journey Cancelled!!");
		}
	}
}
