package com.sathya.springbootmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.springbootmvc.entity.ProductEntity;
import com.sathya.springbootmvc.model.ProductModel;
import com.sathya.springbootmvc.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	public void saveProductDetails(ProductModel productModel) {
		double discountPrice;
		discountPrice=productModel.getPrice()*productModel.getDiscountRate()/100;
		
		double offerPrice;
		offerPrice=productModel.getPrice()-discountPrice;
		
		double taxPrice;
		taxPrice=productModel.getTaxRate()/100 * offerPrice;
		
		double finalePrice;
		finalePrice=taxPrice+offerPrice;
		
		double stockValue;
		stockValue=productModel.getPrice()*productModel.getQuantity();
		
		ProductEntity productEntity=new ProductEntity();
		
		productEntity.setName(productModel.getName());
		productEntity.setBrand(productModel.getBrand());
		productEntity.setMadeIn(productModel.getMadeIn());
		productEntity.setPrice(productModel.getPrice());
		productEntity.setQuantity(productModel.getQuantity());
		productEntity.setDiscountRate(productModel.getDiscountRate());
		productEntity.setTaxRate(productModel.getTaxRate());
		productEntity.setTaxPrice(taxPrice);
		productEntity.setDiscountPrice(discountPrice);
		productEntity.setOfferPrice(offerPrice);
		productEntity.setFinalePrice(finalePrice);
		productEntity.setStockValue(stockValue);
		
		productRepository.save(productEntity);
		
	}
	public List<ProductEntity> getProducts()
	{
		List<ProductEntity> products=productRepository.findAll();
		return products;
	}
	public ProductEntity searchById(Long id) {
		Optional<ProductEntity> optionalData=productRepository.findById(id);
		if(optionalData.isPresent())
		{
			ProductEntity product=optionalData.get();
			return product;
		}
		else
		{
			return null;
		}
		
	}
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}
	
	
	
	public ProductModel editByProductId(Long id) {
	    Optional<ProductEntity> optional = productRepository.findById(id);
	    
	    if (optional.isPresent()) {
	        ProductEntity entity = optional.get();
	        
	        // Convert ProductEntity to ProductModel 
	        ProductModel productModel = new ProductModel();
	        productModel.setName(entity.getName());
	        productModel.setBrand(entity.getBrand());
	        productModel.setMadeIn(entity.getMadeIn());
	        productModel.setPrice(entity.getPrice());
	        productModel.setQuantity(entity.getQuantity());
	        productModel.setDiscountRate(entity.getDiscountRate());
	        productModel.setTaxRate(entity.getTaxRate());
	        
	        return productModel; // Return the populated ProductModel
	    } 
	    else
	    {
	        return null;
	    }
	}
	public void updateProductById(ProductModel productModel, Long id) {
		Optional<ProductEntity> optionals=productRepository.findById(id);
		if (optionals.isPresent()) {
	        ProductEntity entity = optionals.get();
	        
	        // Convert ProductEntity to ProductModel 
	        
	        
	        entity.setName(productModel.getName());
	        entity.setBrand(productModel.getBrand());
	        entity.setMadeIn(productModel.getMadeIn());
	        entity.setPrice(productModel.getPrice());
	        entity.setQuantity(productModel.getQuantity());
	        entity.setDiscountRate(productModel.getDiscountRate());
	        entity.setTaxRate(productModel.getTaxRate());
	        
	        double discountPrice;
			discountPrice=productModel.getPrice()*productModel.getDiscountRate()/100;
			
			double offerPrice;
			offerPrice=productModel.getPrice()-discountPrice;
			
			double taxPrice;
			taxPrice=productModel.getTaxRate()/100 * offerPrice;
			
			double finalePrice;
			finalePrice=taxPrice+offerPrice;
			
			double stockValue;
			stockValue=productModel.getPrice()*productModel.getQuantity();
	        
	        entity.setDiscountPrice(discountPrice);
	        entity.setTaxPrice(taxPrice);
	        entity.setOfferPrice(offerPrice);
	        entity.setFinalePrice(finalePrice);
	        entity.setStockValue(stockValue);
	        
	        productRepository.save(entity);
	   }

    }
}
	

