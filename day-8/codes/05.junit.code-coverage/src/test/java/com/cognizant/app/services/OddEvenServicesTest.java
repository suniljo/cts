package com.cognizant.app.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class OddEvenServicesTest {

	@Test
	void testCheckEvenOrOdd() {
		OddEvenServices services = new OddEvenServices();
		int num = 12;
		assertEquals("EVEN", services.checkEvenOrOdd(num));
	}

	@Test
	void testCheckForOdd() {
		OddEvenServices services = new OddEvenServices();
		int num = 13;
		assertEquals("ODD", services.checkEvenOrOdd(num));
	}	
}
