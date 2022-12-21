package org.astashonok.shared.generators.entities.depends;

import org.astashonok.shared.entities.IOrder;
import org.astashonok.shared.generators.BooleanGenerator;
import org.astashonok.shared.models.depends.impl.OrderDepends;
import org.astashonok.shared.models.depends.impl.OrdersDepends;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class OrderGenerator<O extends IOrder> implements DependsGenerator<O, OrderDepends, OrdersDepends> {

	private BooleanGenerator booleanGenerator = BooleanGenerator.getInstance();

	@Override
	public List<O> getRandomEntities(OrdersDepends depends, Supplier<O> entityConstructor) {
		List<OrderDepends> orderDepends = depends.getDepends();
		List<O> orders = new ArrayList<>(orderDepends.size());

		for (OrderDepends orderDepend : orderDepends) {
			orders.addAll(getOrder(orderDepend, entityConstructor));
		}

		return orders;
	}

	private List<O> getOrder(OrderDepends orderDepends, Supplier<O> entityConstructor) {
		int number = orderDepends.getOrderNumber();

		List<O> orders = new ArrayList<>(number);
		while (number > 0) {
			O order = entityConstructor.get();
			order.setUserId(orderDepends.getUserId());
			order.setActive(booleanGenerator.getRandomValue());
			orders.add(order);
			number--;
		}

		return orders;
	}
}
