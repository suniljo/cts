package com.cognizant.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.cognizant.boot.beans.Car;
import com.cognizant.boot.utils.SecurityUtility;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cognizant", "co.cognizant"})
public class Application {

	public static void main(String[] args) {
		//ApplicationContext context = SpringApplication.run(Application.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		System.out.println("=".repeat(90));
		
		int noOfBeans = context.getBeanDefinitionCount();
		System.out.println("no of beans = " + noOfBeans);
		System.out.println("-".repeat(90));
		
		/*
		String[] beanNames = context.getBeanDefinitionNames();
		for(int i=0; i<beanNames.length; i++) {
			System.out.println(String.format("%2d. %s", (i+1), beanNames[i]));
		}
		*/
		
		/*-- get a bean of type Car from IoC --*/
		//Car carRef = (Car)context.getBean("car");
		//Car carRef = context.getBean("car", Car.class);
		//Car carRef = context.getBean(Car.class);
		Car carRef = (Car)context.getBean("mycar");
		
		carRef.startJourney();
		System.out.println("-".repeat(90));
		
		//SecurityUtility secUtilBean = context.getBean(SecurityUtility.class);
		//SecurityUtility secUtilBean = (SecurityUtility)context.getBean("generateSecurityUtility");
		SecurityUtility secUtilBean = (SecurityUtility)context.getBean("security");
		
		String pass = "12345678";
		String encodedPass = secUtilBean.encodeData(pass);
		System.out.println(encodedPass);
		
		System.out.println("-".repeat(90));
		
		SecurityUtility secUtilBean1 = (SecurityUtility)context.getBean("encoder");
		System.out.println(secUtilBean1.encodeData("password123#"));
		System.out.println("-".repeat(90));
		
		context.close();
	}

}
