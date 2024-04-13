package com.javaspringboot.projetojavaspring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspringboot.projetojavaspring.entities.User;
import com.javaspringboot.projetojavaspring.repositories.UserRepository;

//@Component
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.get();
	}
	
	public User insert(User user) {
		return userRepository.save(user);
	}
}
