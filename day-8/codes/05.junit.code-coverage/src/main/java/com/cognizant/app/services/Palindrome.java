package com.cognizant.app.services;

public class Palindrome {
	public boolean isPalindrome(String input) {
		input = input.toLowerCase().trim();
		String revStr = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			revStr += input.charAt(i);
		}

		if (input.equals(revStr))
			return true;
		else
			return false;
	}
}
