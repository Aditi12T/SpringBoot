package com.axis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.axis.exception.InvalidPriceException;
import com.axis.model.Product;
import com.axis.repository.ProductRepository;

public abstract class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product addProduct(Product product) {
		
		if(product.getPrice()<=0)
			throw new InvalidPriceException("minimum price should be 100");		
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public List<Product> getProductbyId(int id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id),orElseThrow[()-> new IDNotFoundException("no id present")];
	}

	
	
	

}
