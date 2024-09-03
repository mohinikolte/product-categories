package com.ecom.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.entity.Category;
import com.ecom.repository.CategoryRepo;
import com.ecom.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepo categoryRepo;

	@Override
	public List<Category> getAllCategory() {

		return categoryRepo.findAll();
	}

	@Override
	public String addCategory(Category category) {

		categoryRepo.save(category);
		return "Successfully added categories";
	}

	@Override
	public Category findCategoryById(int id) {
		return categoryRepo.findById(id).orElse(null);
	}

	@Override
	public String deleteCategory(int id) {
		categoryRepo.deleteById(id);
		return "Successfully deleted product";
	}

}
