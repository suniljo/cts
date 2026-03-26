package com.cognizant.app.services;

public class Largest {
	
	public int findLargest(int[] nums) {
		//int lar = 0;
		int lar = nums[0];
		for(int x : nums) {
			if(x > lar) {
				lar = x;
			}
		}
		return lar;
	}
}
