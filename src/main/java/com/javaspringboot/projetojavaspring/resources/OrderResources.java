package com.javaspringboot.projetojavaspring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaspringboot.projetojavaspring.entities.Order;
import com.javaspringboot.projetojavaspring.services.OrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderResources {

	@Autowired
	private OrderService orderService;

	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> allOrders = orderService.findAll();
		return ResponseEntity.ok().body(allOrders);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable long id) {
		Order order = orderService.findById(id);
		return ResponseEntity.ok().body(order);
	}

}
