package org.astashonok.springjdbc.entities;

import lombok.Getter;
import lombok.Setter;
import org.astashonok.shared.entities.IOrderItem;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class OrderItem implements IOrderItem {

	private String id;
	private String orderId;
	private String productId;
	private Integer number;
	private Boolean active;
	private LocalDateTime execTime;

	public OrderItem() {
		this.id = UUID.randomUUID().toString();
	}
}
