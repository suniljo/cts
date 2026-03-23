package com.cognizant.lms.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
	@JsonProperty("isbn")
	@XmlElement(name = "isbn")
	private Integer bookId;
	
	@JsonProperty(value = "title")
	@XmlElement(name = "title")
	private String bookTitle;
	
	@JsonProperty("price")
	private Float bookPrice;
}
