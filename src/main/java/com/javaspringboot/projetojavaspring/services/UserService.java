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

	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	public User upadate(Long id, User obj) {
		User user = userRepository.getReferenceById(id);
		updateData(user, obj);
		return userRepository.save(user);
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
