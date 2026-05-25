package com.cognizant.java.util.streams;

import java.util.Arrays;

public class StreamTest {

	public static void main(String[] args) {
		String[] data = {"abc", "def", "ghi", "klm", "abc", "pqr"};
		boolean isPresent = Arrays.stream(data)
								  .anyMatch(str -> {
									  System.out.println(str);
									  return str.equalsIgnoreCase("klm");
								  });
		System.out.println(isPresent);
	}

}
