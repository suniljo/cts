package com.cognizant.app.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName(value = "FIND LARGEST NUMBER TEST CASES")
//@Disabled
//@TestMethodOrder(Alphanumeric.class) //outdated till JUnit 5
//@TestMethodOrder(MethodOrderer.MethodName.class)
@TestMethodOrder(value = org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
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
	@DisplayName("ALL +ve NUMBERS")
	//@Disabled
	@Order(2)
	void shouldReturnPositiveWhenElementsArePositive() {
		//Largest larObj = new Largest();
		
		int[] data = {25, 7, 85, 62, 10, 5};
		
		int expectedValue = 85;
		int actualValue = larObj.findLargest(data);
		
		assertEquals(expectedValue, actualValue);
	}

	@Test
	@DisplayName("+ve and -ve NUMBERS")
	void testFindLargest_for_Positive_Negative_Data() {
		//Largest larObj = new Largest();
		
		int[] data = {-25, 7, -85, -62, 10, 5};
		
		int expectedValue = 10;
		int actualValue = larObj.findLargest(data);
		
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	@DisplayName("ALL -ve NUMBERS")
	void testFindLargestForNegativeNumbers() {
		//Largest larObj = new Largest();
		
		int[] data = {-25, -7, -85, -62, -10, -5};
		
		int expectedValue = -5;
		int actualValue = larObj.findLargest(data);
		
		assertEquals(expectedValue, actualValue, "my expectation failed");
	}	
	
	@Test
	@DisplayName("THROWS EXCEPTION")
	@Order(1)
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
