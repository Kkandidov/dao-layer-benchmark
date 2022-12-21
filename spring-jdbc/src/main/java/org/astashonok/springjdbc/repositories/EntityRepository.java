package org.astashonok.springjdbc.repositories;

import org.astashonok.shared.entities.IEntity;

public interface EntityRepository<E extends IEntity> {

	int save(E entity);
}
