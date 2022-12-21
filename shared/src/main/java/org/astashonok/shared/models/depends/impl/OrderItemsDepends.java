package org.astashonok.shared.models.depends.impl;

import lombok.*;
import org.astashonok.shared.models.depends.EntitiesDepends;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderItemsDepends implements EntitiesDepends<OrderItemDepends> {

	@NonNull
	private List<OrderItemDepends> depends;
}
