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
		boolean carStatus = new Random().nextBoolean();
		if(carStatus)
			System.out.println("Happy Journey");
		else
			System.err.println("Journey Cancelled!!");
	}
	
	@PostConstruct
	public void mySetup() {
		System.out.println("Car - user-defined initialization - post construct");
	}
	
	@PreDestroy
	public void myCleanup() {
		System.out.println("Car - user-defined destructor - pre destroy");
	}	
}
