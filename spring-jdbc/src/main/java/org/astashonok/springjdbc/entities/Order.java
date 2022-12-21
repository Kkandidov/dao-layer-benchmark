package org.astashonok.springjdbc.entities;

import lombok.Getter;
import lombok.Setter;
import org.astashonok.shared.entities.IOrder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Order implements IOrder<OrderItem> {

	private String id;
	private String userId;
	private List<OrderItem> orderItems;
	private Boolean active;
	private LocalDateTime execTime;

	public Order() {
		this.id = UUID.randomUUID().toString();
	}
}
