package com.cognizant.app.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PalindromeTest {
	static Palindrome palObj;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		palObj = new Palindrome();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		palObj = null;
	}

	@ParameterizedTest
	@ValueSource(strings = {"eye", "malayalam", "racecar", "Radar", "liril", "madam"})
	void testIsPalindrome(String str) {
		System.out.println(str);
		boolean actual = palObj.isPalindrome(str);
		assertTrue(actual);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"one", "two", "Three", "Four"})
	void testIsNotPalindrome(String str) {
		System.out.println(str);
		boolean actual = palObj.isPalindrome(str);
		assertFalse(actual);
	}	
}
