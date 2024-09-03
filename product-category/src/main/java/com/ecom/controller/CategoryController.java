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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.entity.Category;
import com.ecom.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping
	public ResponseEntity<List<Category>> getAllCategorys() {

		return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAllCategory());

	}

	@PostMapping
	public ResponseEntity<String> AddCategory(@RequestBody Category category) {
		return ResponseEntity.status(HttpStatus.OK).body(categoryService.addCategory(category));

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") int id) {

		return ResponseEntity.status(HttpStatus.OK).body(categoryService.findCategoryById(id));

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<String> updateCategoryById(@PathVariable("id") int id, @RequestBody Category category) {
		Category c = categoryService.findCategoryById(id);
		if (c != null) {
			return ResponseEntity.status(HttpStatus.OK).body(categoryService.addCategory(category));

		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id not found");

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteCategoryById(@PathVariable("id") int id) {
		return ResponseEntity.status(HttpStatus.OK).body(categoryService.deleteCategory(id));

	}
	

}
