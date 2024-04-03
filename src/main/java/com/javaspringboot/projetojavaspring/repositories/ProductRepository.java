package com.javaspringboot.projetojavaspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaspringboot.projetojavaspring.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
}
