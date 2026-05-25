package com.cognizant.java.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionTest2 {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Sanjay", "Praveen","Aravind", "Bharath", "Wilson", "Charles");
		List<String> namesData = names.stream()
											.map(name -> String.format("%-20s --- %d", name.toUpperCase(), name.length()))
											.collect(Collectors.toList());
		
		namesData.forEach(name -> System.out.println(name));
	}

}
