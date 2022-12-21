package org.astashonok.springjpa.generators;

import org.astashonok.shared.generators.EntityBatchGenerator;
import org.astashonok.springjpa.entities.Order;
import org.astashonok.springjpa.entities.OrderItem;
import org.astashonok.springjpa.entities.Product;
import org.astashonok.springjpa.entities.User;
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
