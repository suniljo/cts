package com.cognizant.java.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Sanjay", "Praveen","Aravind", "Bharath", "Wilson", "Charles");
		System.out.println(names);
		System.out.println();
		
		Comparator<String> compRef = (o1, o2) -> o1.compareTo(o2) > 0 ? 1 : -1;
		
		names.sort(compRef);
		System.out.println(names);
	}
}
