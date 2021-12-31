package com.servir.services.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servir.services.ordermanagement.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
