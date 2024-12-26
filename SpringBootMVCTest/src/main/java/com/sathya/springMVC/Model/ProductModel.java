package com.sathya.springMVC.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
	
	private String name;
	private String brand;
	private double price;
	private String madeIn;
	private int quntity;
	

}
