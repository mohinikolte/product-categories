package com.ecom.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.entity.Product;
import com.ecom.repository.ProductRepo;
import com.ecom.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepo productRepo;

	@Override
	public List<Product> getAllProduct() {

		return productRepo.findAll();
	}

	@Override
	public String addProduct(Product product) {

		productRepo.save(product);
		return "Product successfully added.";
	}

	@Override
	public Product findProductById(int id) {
		return productRepo.findById(id).orElse(null);
	}

	@Override
	public String deleteProduct(int id) {

		productRepo.deleteById(id);
		return "Product successfully deleted.";
	}

}
