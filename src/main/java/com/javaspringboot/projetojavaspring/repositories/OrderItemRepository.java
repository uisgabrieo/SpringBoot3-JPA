package com.javaspringboot.projetojavaspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaspringboot.projetojavaspring.entities.OrderItem;
import com.javaspringboot.projetojavaspring.entities.pk.OrderItemPK;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
	
}
