package org.astashonok.shared.generators.numbers;

import org.astashonok.shared.generators.Generator;

public interface NumberGenerator<T extends Number> extends Generator<T> {

	T getValue(T min, T max);
}
