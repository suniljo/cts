package com.cognizant.app.services;

import java.util.InputMismatchException;

public class Palindrome {
	public boolean isPalindrome(String str) {
		if(str.length() <= 0) {
			throw new InputMismatchException();
		}
		
		str = str.toLowerCase();
		String strRev = "";
		for(int i=str.length()-1; i>=0; i--) {
			strRev = strRev.concat(String.valueOf(str.charAt(i)));
		}
		
		if(str.equals(strRev))
			return true;
		
		return false;
	}
}
