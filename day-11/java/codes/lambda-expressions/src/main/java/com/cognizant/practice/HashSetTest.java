package com.cognizant.practice;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<Product> products = new HashSet<Product>();
		
		Product prod1 = new Product(101, "Apple");
		Product prod2 = new Product(101, "Apple");
		
		System.out.println(prod1.hashCode() + " | " + prod2.hashCode());	
		System.out.println(prod1.equals(prod2));
		
		products.add(prod1);
		products.add(prod2);
		
		System.out.println(products);

	}

}
