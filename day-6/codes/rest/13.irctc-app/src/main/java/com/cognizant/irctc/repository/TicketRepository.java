package com.cognizant.irctc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.irctc.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, String> {

}
