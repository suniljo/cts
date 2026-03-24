package com.cognizant.irctc.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.cognizant.irctc.controllers.adapters.LocalDateAdapter;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Data;

@Entity
@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Ticket {
	@Id
	private String pnr;

	private String passengerName;
	private String fromStation;
	private String toStation;

	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	private LocalDate dateOfJourney;

	private String trainNo;

	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	private LocalDate dateOfBooking;

	private String bookingStatus;
	private Float ticketFare;

	/*
	 * @CreationTimestamp 
	 * private LocalDateTime createdOn;
	 * 
	 * @UpdateTimestamp private 
	 * LocalDateTime updatedOn;
	 */
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;

	@PrePersist
	void onCreate() {
		createdOn = LocalDateTime.now();
	}

	@PreUpdate
	void onUpdate() {
		updatedOn = LocalDateTime.now();
	}
}
