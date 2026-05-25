package com.cognizant.java.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PredicateTest2 {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(11,12,13,14,15,16,17,18,19,20);
		System.out.println(nums);
		
		Stream<Integer> numsStream = nums.stream();
		Stream<Integer> numsStream1 = numsStream.filter(num -> num%2 == 0);
		List<Integer> evenNums = numsStream1.collect(Collectors.toList());
		System.out.println(evenNums);
	}
}
