package com.cognizant.boot.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PetrolEngine implements Engine {

	@Override
	public boolean startEngine() {
		System.out.println("PetrolEngine Starting");
		return true;
	}

}
