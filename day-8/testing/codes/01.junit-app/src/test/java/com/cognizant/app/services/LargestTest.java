package com.cognizant.app.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class LargestTest {
	private static Largest larObj;
	
	@BeforeAll
	public static void initializeTests() {
		System.out.println("-- before all tests ---");
		larObj = new Largest();
	}
	
	@AfterAll
	public static void allTestsCompleted() {
		System.out.println("-- after all tests ---");
		larObj = null;
	}
	
	@Test
	void shouldReturnPositiveWhenElementsArePositive() {
		//Largest larObj = new Largest();
		
		int[] data = {25, 7, 85, 62, 10, 5};
		
		int expectedValue = 85;
		int actualValue = larObj.findLargest(data);
		
		assertEquals(expectedValue, actualValue);
	}

	@Test
	void testFindLargest_for_Positive_Negative_Data() {
		//Largest larObj = new Largest();
		
		int[] data = {-25, 7, -85, -62, 10, 5};
		
		int expectedValue = 10;
		int actualValue = larObj.findLargest(data);
		
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	void testFindLargestForNegativeNumbers() {
		//Largest larObj = new Largest();
		
		int[] data = {-25, -7, -85, -62, -10, -5};
		
		int expectedValue = -5;
		int actualValue = larObj.findLargest(data);
		
		assertEquals(expectedValue, actualValue, "my expectation failed");
	}	
	
	@Test
	void testFindLargest_for_Empty_Data() {
		//Largest larObj = new Largest();
		
		int[] data = {};
		
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> larObj.findLargest(data));
	}	
	
	@BeforeEach
	void beforeEachTest(TestInfo testInfo) {
		System.out.println("before testcase of - " + testInfo.getDisplayName());
	}
	
	@AfterEach
	void afterEachTest(TestInfo testInfo) {
		System.out.println("after testcase of - " + testInfo.getDisplayName()+"\n");
	}	
}
