package com.cognizant.irctc.models;

import java.time.LocalDate;

import com.cognizant.irctc.controllers.adapters.LocalDateAdapter;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Schema(name = "Passenger",
		description = "Schema to hold passenger information")
public class Passenger {
	@NotNull(message = "required")
	@Schema(description = "Name of the passenger", example = "Sunil Joseph" )
	private String passengerName;
	
	@NotEmpty(message = "fromStation is Required")
	@Schema(description = "fromStation of travel", example = "Hyderabad" )
	private String fromStation;
	
	@NotBlank(message = "toStation is Required")
	private String toStation;	
	
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	@Future
	//@FutureOrPresent
	//@Past
	//@PastOrPresent
	private LocalDate dateOfJourney;
	
	@NotNull
	@Size(min = 3, max = 6)
	private String trainNo;
}
