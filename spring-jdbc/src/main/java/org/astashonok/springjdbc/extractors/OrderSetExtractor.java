package org.astashonok.springjdbc.extractors;

import org.astashonok.springjdbc.entities.Order;
import org.astashonok.springjdbc.entities.OrderItem;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderSetExtractor implements ResultSetExtractor<Order> {

	@Override
	public Order extractData(ResultSet rs) throws SQLException {
		Order order = null;

		if (rs.next()) {
			order = new Order();
			List<OrderItem> items = new ArrayList<>();

			fillOrder(rs, order, items);
			fillOrderItem(rs, items);

			while (rs.next()) {
				fillOrderItem(rs, items);
			}
		}

		return order;
	}

	private static void fillOrder(ResultSet rs, Order order, List<OrderItem> items) throws SQLException {
		order.setId(rs.getString("orderid"));
		order.setUserId(rs.getString("userid"));
		order.setActive(rs.getBoolean("orderactive"));
		order.setExecTime(rs.getTimestamp("orderexec").toLocalDateTime());
		order.setOrderItems(items);
	}

	private static void fillOrderItem(ResultSet rs, List<OrderItem> items) throws SQLException {
		OrderItem orderItem = new OrderItem();
		orderItem.setId(rs.getString("orderitemid"));
		orderItem.setProductId(rs.getString("productid"));
		orderItem.setNumber(rs.getInt("number"));
		orderItem.setOrderId(rs.getString("orderid"));
		orderItem.setExecTime(rs.getTimestamp("orderitemexec").toLocalDateTime());
		orderItem.setActive(rs.getBoolean("orderitemactive"));
		items.add(orderItem);
	}
}
