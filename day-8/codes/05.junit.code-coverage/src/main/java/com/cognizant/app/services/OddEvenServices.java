package com.cognizant.app.services;

public class OddEvenServices {
	public String checkEvenOrOdd(int num) {
		int rem = num % 2;
		if (rem == 0) {
			return "EVEN";
		} else {
			return "ODD";
		}
	}
}
