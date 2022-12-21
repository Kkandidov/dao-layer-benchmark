package org.astashonok.springjpa.entities;

import lombok.Getter;
import lombok.Setter;
import org.astashonok.shared.entities.IOrder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "order", schema = "public")
public class Order implements IOrder<OrderItem> {

	@Id
	private String id;

	@Column(name = "\"userId\"")
	private String userId;

	@OneToMany(mappedBy="orderId", fetch = FetchType.EAGER)
	private List<OrderItem> orderItems;
	private Boolean active;

	@Column(name = "\"execTime\"", insertable = false, updatable = false)
	private LocalDateTime execTime;

	public Order() {
		this.id = UUID.randomUUID().toString();
	}
}
