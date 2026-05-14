package com.cognizant.lms.models;

import java.time.LocalDate;
import lombok.Data;

@Data
public class ApiError {
	private String type;
	private String message;
	private Integer statusCode;
	private String api;
	private String method;
	private LocalDate when;
}
