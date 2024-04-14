package com.javaspringboot.projetojavaspring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.javaspringboot.projetojavaspring.entities.User;
import com.javaspringboot.projetojavaspring.repositories.UserRepository;
import com.javaspringboot.projetojavaspring.services.exceptions.DatabaseException;
import com.javaspringboot.projetojavaspring.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User user) {
		return userRepository.save(user);
	}

	public void delete(Long id) {
		try {
			userRepository.deleteById(id);			
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public User upadate(Long id, User obj) {
		try {
			User user = userRepository.getReferenceById(id);
			updateData(user, obj);
			return userRepository.save(user);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User user, User obj) {
		if (obj.getName() != null) {			
			user.setName(obj.getName());
		}
		if (obj.getEmail() != null) {
			user.setEmail(obj.getEmail());
		}
		if (obj.getPhone() != null) {
			user.setPhone(obj.getPhone());
		}
	}
}
