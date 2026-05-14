package com.cognizant.lms.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	@NotNull
	private Integer bookId;
	
	@NotNull(message = "Required")
	@NotEmpty
	@NotBlank
	@Size(min=3, max=20)
	private String bookTitle;
	
	@NotNull
	@Min(value = 100)
	@Max(value = 900)
	private Float bookPrice;
}
