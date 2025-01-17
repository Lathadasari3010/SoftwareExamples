package com.sathya.springbootmvc.model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
	
	@NotBlank(message="Product name cannot be blank")
	private String name;
	
	@NotBlank(message="Product brand cannot be blank")
	private String brand;
	
	@Positive(message="Product Price must be greater than Zero")
	private double price;
	
	@NotBlank(message="Product Made-In cannot be blank")
	private String madeIn;
	
	@Min(value=1,message="Quantity must be atleast 1")
	private int quantity;
	
	@DecimalMax(value="100.0",message="Discount Rate cannot exceed 100")
	private double discountRate;
	
	@DecimalMax(value="40.0",message="Tax Rate cannot exceed 40")
	private double taxRate;

}
