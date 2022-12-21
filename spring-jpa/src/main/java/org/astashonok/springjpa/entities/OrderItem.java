package org.astashonok.springjpa.entities;

import lombok.Getter;
import lombok.Setter;
import org.astashonok.shared.entities.IOrderItem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "\"orderItem\"", schema = "public")
public class OrderItem implements IOrderItem {

	@Id
	private String id;

	@Column(name = "\"orderId\"")
	private String orderId;

	@Column(name = "\"productId\"")
	private String productId;
	private Integer number;
	private Boolean active;

	@Column(name = "\"execTime\"", insertable = false, updatable = false)
	private LocalDateTime execTime;

	public OrderItem() {
		this.id = UUID.randomUUID().toString();
	}
}
