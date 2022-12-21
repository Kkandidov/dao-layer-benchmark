package org.astashonok.shared.models.depends.impl;

import lombok.*;
import org.astashonok.shared.models.depends.EntityDepends;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderItemDepends implements EntityDepends {

	@NonNull
	private String productId;

	@NonNull
	private String orderId;
}
