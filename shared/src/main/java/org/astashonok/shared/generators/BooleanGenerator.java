package org.astashonok.shared.generators;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;
import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BooleanGenerator implements Generator<Boolean> {

	private final Random random = new SecureRandom();

	@Override
	public Boolean getRandomValue() {
		return random.nextBoolean();
	}

	private static final class GeneratorHolder {
		static BooleanGenerator instance = new BooleanGenerator();
	}

	public static BooleanGenerator getInstance() {
		return GeneratorHolder.instance;
	}
}
