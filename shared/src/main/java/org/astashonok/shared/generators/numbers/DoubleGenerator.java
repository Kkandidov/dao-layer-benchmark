package org.astashonok.shared.generators.numbers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;
import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DoubleGenerator implements NumberGenerator<Double> {

	private final Random random = new SecureRandom();

	@Override
	public Double getRandomValue() {
		return random.nextDouble();
	}

	@Override
	public Double getValue(Double min, Double max) {
		return min + (max - min) * random.nextDouble();
	}

	private static final class GeneratorHolder {
		static DoubleGenerator instance = new DoubleGenerator();
	}

	public static DoubleGenerator getInstance() {
		return GeneratorHolder.instance;
	}
}
