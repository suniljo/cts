package com.cognizant.java.lambdas;

public class Calculator {

	public static void main(String[] args) {
		Nums numsRef = (x, y) -> (x + y);
		System.out.println(numsRef.add(12, 23));
	}

}
