package com.javaspringboot.projetojavaspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaspringboot.projetojavaspring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
