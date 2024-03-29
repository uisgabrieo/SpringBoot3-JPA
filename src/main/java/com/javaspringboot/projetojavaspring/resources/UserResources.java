package com.javaspringboot.projetojavaspring.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaspringboot.projetojavaspring.entities.User;

//Recurso web controlado por um controller rest
@RestController
//rota
@RequestMapping(value = "/users")
public class UserResources {
	
	//Retorna um tipo get dos verbos http
	@GetMapping
	//Retornar respostas de requisicoes web
	public ResponseEntity<User> findAll() {
		User user = new User(1L, "Maria", "maria@gmail.com", "9999999", "123456789");	
		
		return ResponseEntity.ok().body(user);
		}
	
}
