package com.ecom.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecom.entity.Product;

@Service
public interface ProductService {

    public List<Product> getAllProduct();

    public String addProduct(Product product);

    public Product findProductById(int id);

    public String deleteProduct(int id);

	
}
