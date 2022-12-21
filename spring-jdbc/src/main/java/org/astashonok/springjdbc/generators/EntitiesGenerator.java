package org.astashonok.springjdbc.generators;

import org.astashonok.shared.generators.EntityBatchGenerator;
import org.astashonok.springjdbc.entities.Order;
import org.astashonok.springjdbc.entities.OrderItem;
import org.astashonok.springjdbc.entities.Product;
import org.astashonok.springjdbc.entities.User;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class EntitiesGenerator extends EntityBatchGenerator<User, Product, Order, OrderItem> {

	@Override
	protected Supplier<User> userSupplier() {
		return User::new;
	}

	@Override
	protected Supplier<Product> productSupplier() {
		return Product::new;
	}

	@Override
	protected Supplier<Order> orderSupplier() {
		return Order::new;
	}

	@Override
	protected Supplier<OrderItem> orderItemSupplier() {
		return OrderItem::new;
	}
}
