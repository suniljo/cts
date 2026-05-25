package com.cognizant.practice;

import java.util.HashMap;
import java.util.Map;

public class HashMapInternal {

	public static void main(String[] args) {
		Map<Employee, String> emps = new HashMap<>();
		
		Employee emp1 = new Employee(101, "Basnath");
		
		emps.put(emp1, "Dev");
		
		int hashCode = emp1.hashCode();
		System.out.println(hashCode);
		int index = hashCode & 15;
		System.out.println(index);
	}

}
