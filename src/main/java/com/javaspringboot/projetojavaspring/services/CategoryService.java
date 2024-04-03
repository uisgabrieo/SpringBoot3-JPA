package com.javaspringboot.projetojavaspring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspringboot.projetojavaspring.entities.Category;
import com.javaspringboot.projetojavaspring.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	public Category findById(Long id) {	
		Optional<Category> category = categoryRepository.findById(id);
		return category.get();
	}
}
