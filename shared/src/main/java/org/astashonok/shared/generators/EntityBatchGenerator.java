package org.astashonok.shared.generators;

import org.astashonok.shared.entities.IOrder;
import org.astashonok.shared.entities.IOrderItem;
import org.astashonok.shared.entities.IProduct;
import org.astashonok.shared.entities.IUser;
import org.astashonok.shared.generators.entities.ProductGenerator;
import org.astashonok.shared.generators.entities.UserGenerator;
import org.astashonok.shared.generators.entities.depends.OrderGenerator;
import org.astashonok.shared.generators.entities.depends.OrderItemGenerator;
import org.astashonok.shared.generators.numbers.IntGenerator;
import org.astashonok.shared.models.EntityBatch;
import org.astashonok.shared.models.depends.impl.OrderDepends;
import org.astashonok.shared.models.depends.impl.OrderItemDepends;
import org.astashonok.shared.models.depends.impl.OrderItemsDepends;
import org.astashonok.shared.models.depends.impl.OrdersDepends;
import org.astashonok.shared.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public abstract class EntityBatchGenerator<U extends IUser, P extends IProduct, O extends IOrder, OI extends IOrderItem> {

	private IntGenerator intGenerator = IntGenerator.getInstance();
	private ProductGenerator<P> productGenerator = new ProductGenerator<>();
	private UserGenerator<U> userGenerator = new UserGenerator<>();

	private OrderGenerator<O> orderGenerator = new OrderGenerator<>();

	protected OrderItemGenerator<OI> orderItemGenerator = new OrderItemGenerator<>();

	public EntityBatch<U, P, O, OI> getEntityBatch(int userCount,
												   int productCount,
												   int singleUserOrderCount,
												   int singleOrderOrderItemCount) {

		List<U> users = userGenerator.getRandomEntities(userCount, userSupplier());
		List<P> products = productGenerator.getRandomEntities(productCount, productSupplier());

		List<String> userIds = CommonUtils.map(users, IUser::getId);
		List<String> productIds = CommonUtils.map(products, IProduct::getId);

		List<O> orders = orderGenerator.getRandomEntities(getOrdersDepends(userIds, singleUserOrderCount), orderSupplier());
		List<String> orderIds = CommonUtils.map(orders, IOrder::getId);

		List<OI> orderItems =
				orderItemGenerator.getRandomEntities(getOrderItemsDepends(productIds, orderIds, singleOrderOrderItemCount), orderItemSupplier());

		return EntityBatch.<U, P, O, OI>builder()
				.users(users)
				.products(products)
				.orders(orders)
				.orderItems(orderItems)
				.build();
	}

	private OrderItemsDepends getOrderItemsDepends(List<String> productIds, List<String> orderIds, int singleOrderOrderItemCount) {
		List<OrderItemDepends> orderItemDepends = new ArrayList<>();

		int productNumber = productIds.size();

		for (String orderId : orderIds) {
			int itemNumber = singleOrderOrderItemCount;
			while (itemNumber > 0) {
				OrderItemDepends itemDepends = OrderItemDepends.builder()
						.productId(productIds.get(intGenerator.getValue(0, productNumber)))
						.orderId(orderId)
						.build();
				orderItemDepends.add(itemDepends);
				itemNumber--;
			}
		}

		return new OrderItemsDepends(orderItemDepends);
	}

	private static OrdersDepends getOrdersDepends(List<String> userIds, int singleUserOrderCount) {
		List<OrderDepends> orderDepends = new ArrayList<>();

		for (String userId : userIds) {
			OrderDepends depends = OrderDepends.builder()
					.userId(userId)
					.orderNumber(singleUserOrderCount)
					.build();

			orderDepends.add(depends);
		}

		return new OrdersDepends(orderDepends);
	}

	protected abstract Supplier<U> userSupplier();
	protected abstract Supplier<P> productSupplier();
	protected abstract Supplier<O> orderSupplier();
	protected abstract Supplier<OI> orderItemSupplier();
}
