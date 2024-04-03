package com.javaspringboot.projetojavaspring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.javaspringboot.projetojavaspring.entities.Category;
import com.javaspringboot.projetojavaspring.entities.Order;
import com.javaspringboot.projetojavaspring.entities.User;
import com.javaspringboot.projetojavaspring.entities.enums.OrderStatus;
import com.javaspringboot.projetojavaspring.repositories.CategoryRepository;
import com.javaspringboot.projetojavaspring.repositories.OrderRepository;
import com.javaspringboot.projetojavaspring.repositories.UserRepository;

//classe expecifica de configuracao
@Configuration
//so vai rodar no perfil de teste
@Profile("test")
public class TestConfig implements CommandLineRunner {

	//associa a dependencia de userrepository
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Sandra", "sandra@gmail.com", "88888888", "123456");
		User user2 = new User(null, "Walquiria", "walquiria@gmail.com", "77777777", "123456");
		
		Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), user1, OrderStatus.PAID); 
		Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), user2, OrderStatus.WAIRING_PAIMENT); 
		Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), user1, OrderStatus.WAIRING_PAIMENT);
		
		Category category1 = new Category(null, "Eletronics");
		Category category2 = new Category(null, "Books");
		Category category3 = new Category(null, "Computers");
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(order1,order2,order3));
		categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
		
	}
}
