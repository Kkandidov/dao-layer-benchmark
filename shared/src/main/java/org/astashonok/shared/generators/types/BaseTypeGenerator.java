package org.astashonok.shared.generators.types;

import org.astashonok.shared.generators.Generator;
import org.astashonok.shared.generators.numbers.IntGenerator;
import org.astashonok.shared.types.FeatureType;

public abstract class BaseTypeGenerator<T extends FeatureType> implements Generator<String> {

	private final T[] featureTypes = getTypeValues();

	private final int typeCount = featureTypes.length;
	private final IntGenerator intGenerator = IntGenerator.getInstance();

	@Override
	public String getRandomValue() {
		return featureTypes[intGenerator.getValue(0, typeCount)].getName();
	}

	protected abstract T[] getTypeValues();
}