package com.cognizant.lms.models;

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "unique ID of book", example = "1001" )
	private Integer bookId;
	
	@NotNull(message = "Required")
	@NotEmpty
	@NotBlank
	@Size(min=3, max=20)
	@Schema(description = "title of book", example = "Java Made Easy" )
	private String bookTitle;
	
	@NotNull
	@Min(value = 100)
	@Max(value = 900)
	private Float bookPrice;
}
