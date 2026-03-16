package com.cognizant;

import java.lang.reflect.Field;

import com.cognizant.models.Product;

public class MainApp {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Product prod = new Product();
		System.out.println(prod);
		
		//prod.productName = "Mouse";
		Class<?> productClass = Class.forName("com.cognizant.models.Product");
		Field prodNameField = productClass.getDeclaredField("productName");
		prodNameField.setAccessible(true);
		
		prodNameField.set(prod, "Mobile");
		System.out.println(prod);
	}

}
