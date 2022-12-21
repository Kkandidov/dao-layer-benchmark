package org.astashonok.shared.generators.numbers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;
import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class IntGenerator implements NumberGenerator<Integer> {

	private final Random random = new SecureRandom();

	@Override
	public Integer getRandomValue() {
		return random.nextInt();
	}

	@Override
	public Integer getValue(Integer min, Integer max) {
		return min + random.nextInt(max - min);
	}

	private static final class GeneratorHolder {
		static IntGenerator instance = new IntGenerator();
	}

	public static IntGenerator getInstance() {
		return GeneratorHolder.instance;
	}
}
