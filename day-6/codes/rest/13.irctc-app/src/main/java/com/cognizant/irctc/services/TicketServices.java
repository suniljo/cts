package com.cognizant.irctc.services;

import com.cognizant.irctc.models.Passenger;
import com.cognizant.irctc.entities.Ticket;

public interface TicketServices {
	public Ticket newBooking(Passenger psngr);
	public Ticket getTicketByPnr(String pnr);
	public Ticket updateTicket(String pnr, Passenger psngr);
	public boolean cancelTicket(String pnr);
}
