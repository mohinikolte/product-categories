package com.ecom.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecom.entity.Category;

@Service
public interface CategoryService {

	public List<Category> getAllCategory();

	public String addCategory(Category category);

	public Category findCategoryById(int id);

	public String deleteCategory(int id);

	
	
}
