package org.astashonok.shared.models.depends.impl;

import lombok.*;
import org.astashonok.shared.models.depends.EntitiesDepends;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrdersDepends implements EntitiesDepends<OrderDepends> {

	@NonNull
	private List<OrderDepends> depends;
}
