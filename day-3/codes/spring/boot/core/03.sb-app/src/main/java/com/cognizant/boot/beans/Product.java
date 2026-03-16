package com.cognizant.boot.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
	private Integer productId;
	private String productName;
	private Float productPrice;
}
