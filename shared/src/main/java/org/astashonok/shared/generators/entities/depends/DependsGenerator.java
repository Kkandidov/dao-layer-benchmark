package org.astashonok.shared.generators.entities.depends;

import org.astashonok.shared.entities.IEntity;
import org.astashonok.shared.models.depends.EntitiesDepends;
import org.astashonok.shared.models.depends.EntityDepends;

import java.util.List;
import java.util.function.Supplier;

public interface DependsGenerator<E extends IEntity, ED extends EntityDepends, D extends EntitiesDepends<ED>> {

	List<E> getRandomEntities(D depends, Supplier<E> entityConstructor);
}
