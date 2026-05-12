package com.cognizant.boot.beans;

import java.util.Random;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

//@Component
//@Component("mycar")
@Component(value = "mycar")
public class Car {

	public Car() {
		System.out.println("Car :: Constructor");
	}

	public void startJourney() {
		boolean journeyStatus = new Random().nextBoolean();
		if(journeyStatus) {
			System.out.println("Happy Journey!!");
		}else {
			System.err.println("Journey Cancelled!!");
		}
	}
	
	@PostConstruct
	public void initializeCar() {
		System.out.println("Car bean created - post-construct steps");
	}
	
	@PreDestroy
	public void cleanUpCar() {
		System.out.println("About to destroy car bean");
	}
}
