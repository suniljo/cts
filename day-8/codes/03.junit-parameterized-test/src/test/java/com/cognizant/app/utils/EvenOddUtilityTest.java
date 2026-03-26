package com.cognizant.app.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class EvenOddUtilityTest {

	@ParameterizedTest
	@CsvSource(value = {"11, odd", "12, even", "13, odd", "14, even"}, delimiter = ',')
	void testCheckOddOrEven(String input, String expected) {
		EvenOddUtility eoUtilObj = new EvenOddUtility();
		String actual = eoUtilObj.checkOddOrEven(Integer.parseInt(input));
		assertEquals(expected, actual);
	}

}
