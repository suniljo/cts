package com.cognizant.java.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class LambdaTest {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Sanjay", "Praveen","Aravind", "Bharath", "Wilson", "Charles", "Sanjay");
		
		//Collections.sort(names);
		/*
		Comparator<String> strComparator = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int n = o1.compareTo(o2);
				if(n > 0)
					return -1;
				else
					return 1;
			}			
		};
		*/
		
		/*
		Comparator<String> strComparator = (str1, str2) -> {
				int n = str1.compareTo(str2);
				if(n > 0)
					return -1;
				else
					return 1;	
		};	
		*/
		
		Comparator<String> strComparator = (str1, str2) -> str2.compareTo(str1);
		
		Collections.sort(names, strComparator);
		System.out.println(names);
		
		Consumer<String> strConsumer = name -> System.out.println(name);				

		names.forEach(strConsumer);
	}

}
