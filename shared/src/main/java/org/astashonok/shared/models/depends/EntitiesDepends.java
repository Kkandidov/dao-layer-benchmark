package org.astashonok.shared.models.depends;

import lombok.NonNull;

import java.util.List;

public interface EntitiesDepends<ED extends EntityDepends> {

	@NonNull
	List<ED> getDepends();
}
