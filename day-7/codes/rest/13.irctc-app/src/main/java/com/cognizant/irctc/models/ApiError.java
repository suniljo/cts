package com.cognizant.irctc.models;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class ApiError {
	private String message;
	private String type;
	private String date;
	private String path;
	private String method;
}
