package org.astashonok.shared.generators.entities.depends;

import org.astashonok.shared.entities.IOrderItem;
import org.astashonok.shared.generators.BooleanGenerator;
import org.astashonok.shared.generators.numbers.IntGenerator;
import org.astashonok.shared.models.depends.impl.OrderItemDepends;
import org.astashonok.shared.models.depends.impl.OrderItemsDepends;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class OrderItemGenerator<OI extends IOrderItem> implements DependsGenerator<OI, OrderItemDepends, OrderItemsDepends> {

	private BooleanGenerator booleanGenerator = BooleanGenerator.getInstance();
	private IntGenerator intGenerator = IntGenerator.getInstance();

	@Override
	public List<OI> getRandomEntities(OrderItemsDepends depends, Supplier<OI> entityConstructor) {
		List<OrderItemDepends> orderItemDepends = depends.getDepends();
		List<OI> orderItems = new ArrayList<>(orderItemDepends.size());

		for (OrderItemDepends depend : orderItemDepends) {
			orderItems.add(getOrderItem(depend, entityConstructor));
		}

		return orderItems;
	}

	private OI getOrderItem(OrderItemDepends orderItemDepend, Supplier<OI> entityConstructor) {
		OI orderItem = entityConstructor.get();
		orderItem.setOrderId(orderItemDepend.getOrderId());
		orderItem.setProductId(orderItemDepend.getProductId());
		orderItem.setNumber(intGenerator.getValue(1, 10));
		orderItem.setActive(booleanGenerator.getRandomValue());
		return orderItem;
	}
}
