package com.cognizant.app.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

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

	@Test
	@DisplayName(value = "Palindrome")
	@RepeatedTest(value = 3, name = "{displayName} --> {currentRepetition} of {totalRepetitions}")
	void testIsPalindrome() {
		String str = "madam";
		assertTrue(palObj.isPalindrome(str));
	}

	@Test
	void shouldReturnFalse() {
		String str = "java";
		assertFalse(palObj.isPalindrome(str));
	}	
}
