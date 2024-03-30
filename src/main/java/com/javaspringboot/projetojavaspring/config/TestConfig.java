package com.javaspringboot.projetojavaspring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.javaspringboot.projetojavaspring.entities.User;
import com.javaspringboot.projetojavaspring.repositories.UserRepository;

//classe expecifica de configuracao
@Configuration
//so vai rodar no perfil de teste
@Profile("test")
public class TestConfig implements CommandLineRunner {

	//associa a dependencia de userrepository
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Sandra", "sandra@gmail.com", "88888888", "123456");
		User user2 = new User(null, "Walquiria", "walquiria@gmail.com", "77777777", "123456");
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		
	}
}
