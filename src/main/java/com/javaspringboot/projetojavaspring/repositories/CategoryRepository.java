package com.javaspringboot.projetojavaspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaspringboot.projetojavaspring.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
}
