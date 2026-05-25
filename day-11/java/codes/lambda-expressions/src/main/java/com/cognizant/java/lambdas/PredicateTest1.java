package com.cognizant.java.lambdas;

import java.util.function.Predicate;

public class PredicateTest1 {

	public static void main(String[] args) {
		int num = 26;
		
		Predicate<Integer> evenPredicate = data -> data%2 == 0;
		
		boolean evenStatus = evenPredicate.test(num);
		
		if(evenStatus)
			System.out.println(num + " is Even");
		else
			System.err.println(num + " is NOT Even");
	}

}
