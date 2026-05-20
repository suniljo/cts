package com.cognizant.app.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.InputMismatchException;

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
	void testIsPalindrome() {
		String str = "madam";
		boolean resultValue = palObj.isPalindrome(str);
		assertTrue(resultValue);
	}

	@Test
	void shouldReturnFalse() {
		String str = "java";
		boolean resultValue = palObj.isPalindrome(str);
		assertFalse(resultValue);
	}
	
	@Test
	void testForEmptyData() {
		String str = "";
		assertThrows(InputMismatchException.class, () -> palObj.isPalindrome(str));
	}
	
	@Test
	void testForNullData() {
		String str = null;
		assertThrows(NullPointerException.class, () -> palObj.isPalindrome(str));
	}
	
	@Test
	@DisplayName(value = "Palindrome")
	@RepeatedTest(value = 3, name = "{displayName} --> {currentRepetition} of {totalRepetitions}")
	void testIsPalindromeForRepeatedData() {
		String str = "eye";
		assertTrue(palObj.isPalindrome(str));
	}	
}
