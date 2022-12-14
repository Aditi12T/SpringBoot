package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.exception.IDNotFoundException;
import com.axis.model.Product;
import com.axis.service.ProductService;

@RestController
@RequestMapping("/api/vi")
public class ProductController {
	
	private static final HttpStatusCode HttpStatus = null;
	@Autowired
	ProductService productService;
	
	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		Product product2 = productService.addProduct(product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts()
	{
		List<Product> products = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	@GetMapping("/product/id")
	public ResponseEntity<List<Product>> getProductById(@PathVariable int id )
	{
		List<Product> product = productService.getProductbyId(id);
		return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
	}
	
	
	
}
