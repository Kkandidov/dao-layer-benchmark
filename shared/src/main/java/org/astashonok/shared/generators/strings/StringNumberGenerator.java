package org.astashonok.shared.generators.strings;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StringNumberGenerator implements StringGenerator {

	@Override
	public String getRandomValue() {
		return RandomStringUtils.random(7, false, true);
	}

	@Override
	public String getValue(int characters) {
		return RandomStringUtils.random(characters, false, true);
	}

	private static final class GeneratorHolder {
		static StringNumberGenerator instance = new StringNumberGenerator();
	}

	public static StringNumberGenerator getInstance() {
		return GeneratorHolder.instance;
	}
}
