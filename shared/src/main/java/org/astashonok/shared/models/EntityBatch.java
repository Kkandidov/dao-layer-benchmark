package org.astashonok.shared.models;

import org.astashonok.shared.entities.IOrder;
import org.astashonok.shared.entities.IOrderItem;
import org.astashonok.shared.entities.IProduct;
import org.astashonok.shared.entities.IUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EntityBatch<U extends IUser, P extends IProduct, O extends IOrder, OI extends IOrderItem> {

	private List<U> users;
	private List<P> products;
	private List<O> orders;
	private List<OI> orderItems;
}
