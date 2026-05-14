package com.cognizant.lms.models;

import java.time.LocalDate;

import com.cognizant.lms.marshler.LocalDateTimeAdapter;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@XmlRootElement
@NoArgsConstructor
public class ApiError {
	private String type;
	private String message;
	private Integer statusCode;
	private String api;
	private String method;
	
	//@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	private LocalDate when;
}
