package com.cognizant.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@SpringBootConfiguration
@ComponentScan
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		System.out.println("=".repeat(80));
		
		int noOfBeans = context.getBeanDefinitionCount();
		System.out.println("no of beans configured = " + noOfBeans);
		System.out.println("=".repeat(80));
		
		String[] beanNames = context.getBeanDefinitionNames();
		for(int i=0; i<beanNames.length; i++) {
			System.out.println(String.format("%2d. %s", (i+1), beanNames[i]));
		}
	}
}
