package com.cognizant.irctc.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.irctc.entities.Ticket;
import com.cognizant.irctc.models.Passenger;
import com.cognizant.irctc.services.TicketServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/irctc/ticket")
@Tag(name = "Ticket Booking Controller", 
	 description = "New Booking, Search, Cancel, Reschedule Ticket")
public class TicketRestController {
	@Autowired
	private TicketServices ticketServices;
	
	@PostMapping(produces = {"application/json", "application/xml"},
				 consumes = {"application/json", "application/xml"})
	@Operation(summary = "New Ticket Booking",
    		 description = "booking a new train ticket based on passenger info")
	public ResponseEntity<Ticket> newTicketBooking(@Valid @RequestBody Passenger psngr){
		Ticket ticket = ticketServices.newBooking(psngr);
		return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/{pnr}",
			produces = {"application/json", "application/xml"})
	public ResponseEntity<Ticket> searchTicketByPnr(@PathVariable String pnr){
		Ticket ticket = ticketServices.getTicketByPnr(pnr);
		if(ticket != null)
			return ResponseEntity.ok().body(ticket);
		
		return ResponseEntity.badRequest().build();
	}	
	
	@DeleteMapping(path = "/{pnr}")
	public ResponseEntity<Ticket> cancelTicketByPnr(@PathVariable String pnr){
		boolean deleteStatus = ticketServices.cancelTicket(pnr);
		if(deleteStatus)
			return ResponseEntity.ok().build();
		
		return ResponseEntity.badRequest().build();
	}	
}
