package com.cognizant.boot.beans;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn(value = "dataWriter")
public class DataReader {

	public DataReader() {
		System.out.println("DataReader :: Constructor");
	}

}
