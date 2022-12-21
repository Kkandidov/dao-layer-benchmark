package org.astashonok.shared.models.depends.impl;

import lombok.*;
import org.astashonok.shared.models.depends.EntityDepends;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderDepends implements EntityDepends {

	@NonNull
	private String userId;
	private int orderNumber;
}
