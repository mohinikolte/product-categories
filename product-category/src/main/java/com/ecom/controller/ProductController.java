package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.entity.Product;
import com.ecom.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {



	@Autowired
	ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {

		return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProduct());

	}

	@PostMapping
	public ResponseEntity<String> AddProduct(@RequestBody Product Product) {
		return ResponseEntity.status(HttpStatus.OK).body(productService.addProduct(Product));

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {

		return ResponseEntity.status(HttpStatus.OK).body(productService.findProductById(id));

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<String> updateProductById(@PathVariable("id") int id, @RequestBody Product Product) {
		Product c = productService.findProductById(id);
		if (c != null) {
			return ResponseEntity.status(HttpStatus.OK).body(productService.addProduct(Product));

		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found");

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable("id") int id) {
		return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProduct(id));

	}


}
