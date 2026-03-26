package com.cognizant.app.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

//@TestMethodOrder(Alphanumeric.class)
@TestMethodOrder(value = org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
@DisplayName(value = "FIND LARGEST NUMBER TEST CASES")
//@Disabled
class LargestTest {
	static Largest larObj = null;
	
	@BeforeAll
	public static void initializeTests() {
		System.out.println("before all tests!!");
		larObj = new Largest();
	}

	@AfterAll
	public static void afterAllTests() {
		System.out.println("after all tests!!");
		larObj = null;
	}	
	
	@Test
	@DisplayName("ALL +ve NUMBERS")
	//@Disabled
	@Order(2)
	void shouldReturnPositiveWhenElementsArePositive() {
		//Largest larObj = new Largest();
		
		int[] nums = {20, 15, 75, 36, 14, 10};
		int expectedValue = 75;
		
		int actualValue = larObj.findLargest(nums);
		assertEquals(expectedValue, actualValue);
	}

	@Test
	@DisplayName("+ve and -ve NUMBERS")
	@Order(1)
	void testFindLargest_for_Positive_Negative_Data() {
		//Largest larObj = new Largest();
		
		int[] nums = {-20, 15, -75, -36, 14, 10};
		int expectedValue = 15;
		
		int actualValue = larObj.findLargest(nums);
		assertEquals(expectedValue, actualValue);
	}	
	
	@Test
	@DisplayName("ALL -ve NUMBERS")
	@Order(4)
	void testFindLargestForNegativeNumbers() {
		//Largest larObj = new Largest();
		
		int[] nums = {-20, -15, -75, -36, -14, -10};
		int expectedValue = -10;
		
		int actualValue = larObj.findLargest(nums);
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	@DisplayName("THROWS EXCEPTION")
	@Order(3)
	void testFindLargest_for_Empty_Data() {
		//Largest larObj = new Largest();
		
		int[] nums = {};
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> larObj.findLargest(nums));
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
