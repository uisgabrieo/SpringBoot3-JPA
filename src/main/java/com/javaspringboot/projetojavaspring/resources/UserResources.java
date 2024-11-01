package com.javaspringboot.projetojavaspring.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<User> findById(@PathVariable Long id) {
		
		User user = userService.findById(id);
		
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user){
		user = userService.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
		User updateUser = userService.upadate(id, user);
		return ResponseEntity.ok().body(updateUser);
		
	}
}
