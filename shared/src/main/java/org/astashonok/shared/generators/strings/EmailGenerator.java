package org.astashonok.shared.generators.strings;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EmailGenerator implements StringGenerator {

	@Override
	public String getValue(int characters) {
		return RandomStringUtils.randomAlphabetic(characters) + "@gmail.com";
	}

	@Override
	public String getRandomValue() {
		return RandomStringUtils.randomAlphabetic(10) + "@gmail.com";
	}

	private static final class GeneratorHolder {
		static EmailGenerator instance = new EmailGenerator();
	}

	public static EmailGenerator getInstance() {
		return GeneratorHolder.instance;
	}
}
