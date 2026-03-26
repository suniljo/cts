package com.cognizant.app.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class EvenOddUtilityTest1 {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv") //data.csv - src/test/resources
	void testCheckOddOrEven(String input, String expected) {
		System.out.println(input + " - " + expected);
		EvenOddUtility eoUtilObj = new EvenOddUtility();
		String actual = eoUtilObj.checkOddOrEven(Integer.parseInt(input));
		assertEquals(expected, actual);
	}
}
