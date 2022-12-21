package org.astashonok.springjdbc.repositories.impl;

import org.astashonok.springjdbc.entities.Order;
import org.astashonok.springjdbc.extractors.OrderSetExtractor;
import org.astashonok.springjdbc.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

	private static final String INSERT_ORDER_QUERY = "INSERT INTO \"order\"(id, \"userId\", "
			+ "active) VALUES (?, ?, ?)";

	private static final String FIND_BY_ID_QUERY = "SELECT \"order\".id orderid, \"order\".\"userId\" userid, \"order\".active orderactive," +
			"       \"order\".\"execTime\" orderexec, \"orderItem\".id orderitemid, \"orderItem\".\"productId\" productid," +
			"       \"orderItem\".number, \"orderItem\".active orderitemactive, \"orderItem\".\"execTime\" orderitemexec" +
			"       FROM \"order\" JOIN \"orderItem\" on \"order\".id = \"orderItem\".\"orderId\" WHERE \"order\".id = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private OrderSetExtractor orderSetExtractor;

	@Override
	public int save(Order entity) {
		return jdbcTemplate.update(INSERT_ORDER_QUERY, entity.getId(), entity.getUserId(), entity.getActive());
	}

	@Override
	public Order findById(String id) {
		return jdbcTemplate
				.query(FIND_BY_ID_QUERY, orderSetExtractor, id);
	}
}
