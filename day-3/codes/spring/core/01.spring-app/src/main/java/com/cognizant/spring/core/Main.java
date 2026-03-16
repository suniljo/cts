package com.cognizant.spring.core;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//-- initialize Spring container
		//BeanFactory factory = new ClassPathXmlApplicationContext("user-beans.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("user-beans.xml");
		
		System.out.println("=".repeat(80));
		
		int noOfBeans = context.getBeanDefinitionCount();
		System.out.println("no of beans configured = " + noOfBeans);
		System.out.println("=".repeat(80));
		
		System.out.println("\n************** BEAN NAMES *******************\n");
		String[] beanNames = context.getBeanDefinitionNames();
		
		Arrays.stream(beanNames).forEach(beanName -> System.out.println(beanName));
	}

}
