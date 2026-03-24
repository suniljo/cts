package com.cognizant.irctc.services.impl;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.irctc.models.Passenger;
import com.cognizant.irctc.entities.Ticket;
import com.cognizant.irctc.exceptions.TicketNotFoundException;
import com.cognizant.irctc.repository.TicketRepository;
import com.cognizant.irctc.services.TicketServices;
import com.cognizant.irctc.utility.PNRGenerator;

@Service
public class TicketServicesImpl implements TicketServices {
	private TicketRepository ticketRepo;
	private PNRGenerator pnrGen;
	
	public TicketServicesImpl(TicketRepository ticketRepo, PNRGenerator pnrGen) {
		super();
		this.ticketRepo = ticketRepo;
		this.pnrGen = pnrGen;
	}

	@Override
	public Ticket newBooking(Passenger psngr) {
		Ticket ticket = new Ticket();
		
		ticket.setPassengerName(psngr.getPassengerName());
		ticket.setFromStation(psngr.getFromStation());
		ticket.setToStation(psngr.getToStation());
		ticket.setDateOfJourney(psngr.getDateOfJourney());
		ticket.setTrainNo(psngr.getTrainNo());
		
		String ticketStatus = new Random().nextBoolean() ? "CONFIRMED" : "WAITING";
		ticket.setBookingStatus(ticketStatus);
		
		ticket.setDateOfBooking(LocalDate.now());
		
		float fare = new Random().nextFloat(1000, 3000);
		float roundedValue = Math.round(fare * 100.0f) / 100.0f;
		ticket.setTicketFare(roundedValue);
		
		String pnr = pnrGen.generatePNR();
		ticket.setPnr(pnr);
		
		Ticket bookedTicket = ticketRepo.save(ticket);
		
		return bookedTicket;
	}

	@Override
	public Ticket getTicketByPnr(String pnr) {
		Optional<Ticket> optTicket = ticketRepo.findById(pnr);
		if(optTicket.isPresent()) {
			return optTicket.get();
		}	
		//return null;
		throw new TicketNotFoundException("No ticket available for PNR: "+pnr);
	}

	@Override
	public Ticket updateTicket(String pnr, Passenger psngr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cancelTicket(String pnr) {
		boolean ticketExists = ticketRepo.existsById(pnr);
		//System.out.println(ticketExists);
		if(ticketExists) {
			ticketRepo.deleteById(pnr);
			return true;
		}
		//return false;
		throw new TicketNotFoundException("No ticket available for PNR: "+pnr);
	}

}
