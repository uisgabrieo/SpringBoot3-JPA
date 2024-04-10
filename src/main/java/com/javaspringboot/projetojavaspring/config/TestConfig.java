package com.javaspringboot.projetojavaspring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.javaspringboot.projetojavaspring.entities.Category;
import com.javaspringboot.projetojavaspring.entities.Order;
import com.javaspringboot.projetojavaspring.entities.OrderItem;
import com.javaspringboot.projetojavaspring.entities.Product;
import com.javaspringboot.projetojavaspring.entities.User;
import com.javaspringboot.projetojavaspring.entities.enums.OrderStatus;
import com.javaspringboot.projetojavaspring.repositories.CategoryRepository;
import com.javaspringboot.projetojavaspring.repositories.OrderItemRepository;
import com.javaspringboot.projetojavaspring.repositories.OrderRepository;
import com.javaspringboot.projetojavaspring.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		Category category1 = new Category(null, "Eletronics");
		Category category2 = new Category(null, "Books");
		Category category3 = new Category(null, "Computers");
		
		Product product1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product product2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product product3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product product4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product product5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
		productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

		product1.getCategories().add(category2);
		product2.getCategories().add(category1);
		product2.getCategories().add(category3);
		product3.getCategories().add(category3);
		product4.getCategories().add(category3);
		product5.getCategories().add(category2);
		
		productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));
		
		User user1 = new User(null, "Sandra", "sandra@gmail.com", "88888888", "123456");
		User user2 = new User(null, "Walquiria", "walquiria@gmail.com", "77777777", "123456");
		
		Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), user1, OrderStatus.PAID); 
		Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), user2, OrderStatus.WAIRING_PAIMENT); 
		Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), user1, OrderStatus.WAIRING_PAIMENT);
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(order1,order2,order3));
		
		OrderItem orderItens1 = new OrderItem(order1, product1, 2, product1.getPrice()); 
		OrderItem orderItens2 = new OrderItem(order1, product3, 1, product3.getPrice()); 
		OrderItem orderItens3 = new OrderItem(order2, product3, 2, product3.getPrice()); 
		OrderItem orderItens4 = new OrderItem(order3, product5, 2, product5.getPrice()); 
		
		orderItemRepository.saveAll(Arrays.asList(orderItens1, orderItens2, orderItens3, orderItens4));
		
		
		
		
	}
}
