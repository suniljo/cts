package com.cognizant.lms.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
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
	//@JsonProperty("isbn")
	//@XmlElement(name = "isbn")
	@NotNull
	private Integer bookId;
	
	//@JsonProperty(value = "title")
	//@XmlElement(name = "title")
	@NotNull(message = "title is required")
	@NotEmpty
	@NotBlank
	@Size(min = 3, max = 10)
	@Schema(defaultValue = "Java")
	private String bookTitle;
	
	//@JsonProperty("price")
	@NotNull
	@Min(100)
	@Max(999)
	private Float bookPrice;
}
