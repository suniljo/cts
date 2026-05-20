package com.cognizant.app.utils;

public class EvenOddUtility {
	
	public String checkOddOrEven(int num) {
		int rem = num % 2;
		
		if(rem == 0)
			return "even";
		return "odd";
	}
}
