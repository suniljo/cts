package com.cognizant.boot.beans;

import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class DieselEngine implements Engine{

	@Override
	public boolean startEngine() {
		System.out.println("DieselEngine Starting");
		return new Random().nextBoolean();
	}

}
