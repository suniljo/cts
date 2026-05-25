package com.cognizant.java.util.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(10,12,14,12,14,18,17,19,18,17);
		System.out.println(nums);
		
		Stream<Integer> distinctNumsStream = nums.stream().distinct();
		
		List<Integer> distictNums = distinctNumsStream.collect(Collectors.toList());
		System.out.println(distictNums);
		
		Optional<Integer> optNum =  nums.stream().max(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				System.out.println(o1 + " - " + o2);
				try {
					Thread.sleep(1000);
				}catch(Exception ex) {}
				return o1 - o2;
			}
			
		});
		if(optNum.isPresent()) {
			int maxNum = optNum.get();
			System.out.println(maxNum);
		}
		System.out.println();
		
		List<Integer> marks = Arrays.asList(65, 82, 76, 60, 92, 81, 50);
		OptionalDouble optAvg = marks.stream()
									 .mapToInt(n -> n)
									 .average();
		if(optAvg.isPresent())
			System.out.println(optAvg.getAsDouble());
	}

}
