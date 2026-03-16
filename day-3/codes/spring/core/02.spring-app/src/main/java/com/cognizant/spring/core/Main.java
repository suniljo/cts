package com.cognizant.spring.core;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.spring.core.beans.User;

public class Main {

	public static void main(String[] args) {
		//-- initialize Spring container
		ApplicationContext context = new ClassPathXmlApplicationContext("user-beans.xml");
		
		System.out.println("=".repeat(80));
		
		Object obj = context.getBean("user1");
		User usr1 = null;
		
		if(obj instanceof User) {
			usr1 = (User)obj;
			System.out.println(usr1);
		}
		System.out.println("-".repeat(80));
		User usr2 = (User)context.getBean("user1");
		System.out.println(usr2);
		
		System.out.println("-".repeat(80));
		User usr3 = context.getBean("user1", User.class);
		System.out.println(usr3);	
		System.out.println("-".repeat(80));
		
		System.out.println(usr1.hashCode() + " | " + usr2.hashCode() + " | " + usr3.hashCode());
		System.out.println("-".repeat(80));		
		
		User usr4 = (User)context.getBean("user2");
		System.out.println(usr4);
	}

}
