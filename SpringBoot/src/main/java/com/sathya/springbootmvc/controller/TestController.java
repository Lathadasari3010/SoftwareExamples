package com.sathya.springbootmvc.controller;



import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathya.springbootmvc.entity.ProductEntity;
import com.sathya.springbootmvc.model.ProductModel;
import com.sathya.springbootmvc.service.ProductService;

import jakarta.validation.Valid;

@Controller
public class TestController {
	@Autowired
	 
	ProductService productService;
	
	
	@GetMapping("/productform")
	public String getProduct(Model model)
	{
		ProductModel productModel=new ProductModel();
		productModel.setMadeIn("India");
		productModel.setDiscountRate(10.5);
		productModel.setQuantity(2);
		model.addAttribute("productModel",productModel);
		return "addproduct";
	}
	@PostMapping("/saveProduct")
	public String saveProduct(@Valid ProductModel productModel,BindingResult bindingResult,Model model)
	{
		HashMap<String, String> validationErrors=new HashMap<String,String>();

		if(bindingResult.hasErrors())
		{
			for(FieldError fieldError: bindingResult.getFieldErrors())
			{
				validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
			}
			model.addAttribute("validationErrors",validationErrors);
			return "addproduct";
		}
		
		
		productService.saveProductDetails(productModel);
			return "redirect:/getallproducts";
		
	}
	
	//To get the list of products(all products)
	@GetMapping("/getallproducts")
	public String getAllProducts(Model model)
	{
		List<ProductEntity> products=productService.getProducts();
		model.addAttribute("products",products);
		return "product-list";
	}
	
	//To get the product based the id
	@GetMapping("/searchproduct")
	public String getProductId()
	{
		return "search-product";
	}

	@PostMapping("/searchbyid")
	public String getProductById(@RequestParam  Long id,Model model)
	{
		ProductEntity product=productService.searchById(id);
		model.addAttribute("product", product);
		return "search-product";
	}
	
	//delete the product based on the id
	
	@GetMapping("/delete/{id}")
	public String deleteByIdForm(@PathVariable Long id)
	{
		productService.deleteProductById(id);
		return "redirect:/getallproducts";
	}                                                                         
	//Edit and update the data based on id
	
	@GetMapping("/edit/{id}")
	public String editById(@PathVariable Long id, Model model) {
	    ProductModel product = productService.editByProductId(id);  // Call service to get the product by ID
	    model.addAttribute("product", product); // Add product to model for the view
	    model.addAttribute("id", id);
	    return "edit-product";  // Return the edit product view
	}
	
	@PostMapping("/editproductsave/{id}")
	public String updateById(@PathVariable Long id,ProductModel productModel)
	{
		productService.updateProductById(productModel,id);
		return "redirect:/getallproducts";
	}
	
	
	

}
