package com.cognizant.lms.models;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApiError {
	private String type;
	private String message;
	private Integer status;
	private LocalDateTime time;
	private String uri;
	private String method;
}
