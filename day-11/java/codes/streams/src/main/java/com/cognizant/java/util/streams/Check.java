package com.cognizant.java.util.streams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class Check {

	public static void main(String[] args) {
		/*
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "    ");
			}
			System.out.println();
		}
		*/
		
		IntStream.rangeClosed(1, 5)
				 .forEach(n -> {
					 IntStream.rangeClosed(1, n)
					 		  .forEach(x -> System.out.print(x+"   "));
				   System.out.println();	 
				 });
		
		List<Integer> marks = Arrays.asList(65, 82, 76, 60, 92, 81, 50);
		OptionalDouble optAvg = marks.stream()
									 .mapToInt(n -> n)
									 .average();
		if(optAvg.isPresent())
			System.out.println(optAvg.getAsDouble());
	}

}
