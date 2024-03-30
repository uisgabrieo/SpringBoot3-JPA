package com.javaspringboot.projetojavaspring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaspringboot.projetojavaspring.entities.User;
import com.javaspringboot.projetojavaspring.services.UserService;

//Recurso web controlado por um controller rest
@RestController
//rota
@RequestMapping(value = "/users")
public class UserResources {
	
	@Autowired
	private UserService userService;
	
	//Retorna um tipo get dos verbos http
	@GetMapping
	//Retornar respostas de requisicoes web
	public ResponseEntity<List<User>> findAll() {
		List<User> allUsers = userService.findAll();
		
		return ResponseEntity.ok().body(allUsers);
		}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable long id) {
		
		User user = userService.findById(id);
		
		return ResponseEntity.ok().body(user);
	}

}
