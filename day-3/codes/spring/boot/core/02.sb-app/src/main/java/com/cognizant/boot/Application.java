package com.cognizant.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.cognizant.boot.beans.Car;
import com.cognizant.boot.utils.SecurityUtility;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.cognizant.boot", "co.cognizant"})
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		System.out.println("=".repeat(80));
		
		int noOfBeans = context.getBeanDefinitionCount();
		System.out.println("no of beans = " + noOfBeans);
		System.out.println("=".repeat(80));
		
		/*-- get a bean of type Car from IoC --*/
		//Car carRef = context.getBean(Car.class);
		//Car carRef = (Car) context.getBean("car");
		//Car carRef = context.getBean("car", Car.class);
		Car carRef = (Car) context.getBean("mycar");
		
		carRef.startJourney();
		System.out.println("=".repeat(80));
		
		String myData = "password123#";
		
		//SecurityUtility secUtilBean = context.getBean(SecurityUtility.class);
		//SecurityUtility secUtilBean = (SecurityUtility) context.getBean("getSecurityUtilityBean");
		//SecurityUtility secUtilBean = (SecurityUtility) context.getBean("encoder");
		//SecurityUtility secUtilBean = (SecurityUtility) context.getBean("security");
		SecurityUtility secUtilBean = (SecurityUtility) context.getBean("security");
		
		String encodedData = secUtilBean.encodeData(myData);
		System.out.println(encodedData);
		System.out.println("=".repeat(80));
		
		SecurityUtility secUtilBean1 = (SecurityUtility) context.getBean("encoder");
		System.out.println("=".repeat(80));
		context.close();
	}

}
