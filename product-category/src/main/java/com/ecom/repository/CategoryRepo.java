package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
