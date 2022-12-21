package org.astashonok.springjpa.repositories;

import org.astashonok.springjpa.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
