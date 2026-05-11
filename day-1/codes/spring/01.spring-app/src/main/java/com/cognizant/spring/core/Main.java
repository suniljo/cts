package com.cognizant.spring.core;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//-- initialize spring container
		ApplicationContext context = new ClassPathXmlApplicationContext("user-beans.xml");
		System.out.println("-".repeat(80));
		
		int noOfBeans = context.getBeanDefinitionCount();
		System.out.println(String.format("no of beans configured = %d", noOfBeans));
		System.out.println("-".repeat(80));
		
		System.out.println("================= BEAN NAMES =================");
		String[] beanNames = context.getBeanDefinitionNames();
		
		/*
		Arrays.stream(beanNames)
			  .forEach(beanName -> System.out.println("---> " + beanName));
		*/
		Arrays.stream(beanNames)
			  .forEach(System.out::println);
	}

}
