package org.astashonok.springjdbc.repositories.impl;

import org.astashonok.springjdbc.entities.OrderItem;
import org.astashonok.springjdbc.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository {

	private static final String INSERT_ORDER_ITEM_QUERY = "INSERT INTO \"orderItem\"(id, \"orderId\", "
			+ "\"productId\", number, active) VALUES (?, ?, ?, ?, ?)";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int save(OrderItem entity) {
		return jdbcTemplate.update(INSERT_ORDER_ITEM_QUERY, entity.getId(), entity.getOrderId(), entity.getProductId(),
				entity.getNumber(), entity.getActive());
	}
}
