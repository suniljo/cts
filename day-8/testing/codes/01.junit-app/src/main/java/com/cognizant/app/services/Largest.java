package com.cognizant.app.services;

public class Largest {

	public int findLargest(int[] elements) {
		//int lar = 0;
		int lar = elements[0];
		
		for(int i=1; i<elements.length; i++) {
			if(elements[i] > lar) {
				lar = elements[i];
			}
		}
		return lar;
	}
}
