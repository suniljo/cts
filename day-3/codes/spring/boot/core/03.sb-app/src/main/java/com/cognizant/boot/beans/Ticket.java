package com.cognizant.boot.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Ticket {
	@Value("RFD4536U")
	private String pnr;
	
	@Value("${psngrName}")
	private String passengerName;


	@Override
	public String toString() {
		return "Ticket [pnr=" + pnr + ", passengerName=" + passengerName + "]";
	}
}
