package org.astashonok.shared.generators.entities;

import java.util.List;
import java.util.function.Supplier;

public interface EntityGenerator<T> {

	List<T> getRandomEntities(int capacity, Supplier<T> entityConstructor);

	T getRandomEntity(Supplier<T> entityConstructor);
}
