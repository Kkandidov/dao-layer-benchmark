package org.astashonok.springjdbc.repositories;

import org.astashonok.springjdbc.entities.Order;

public interface OrderRepository extends EntityRepository<Order> {

	Order findById(String id);
}
