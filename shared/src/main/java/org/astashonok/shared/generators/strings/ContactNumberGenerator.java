package org.astashonok.shared.generators.strings;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ContactNumberGenerator implements StringGenerator {

	@Override
	public String getRandomValue() {
		return "+37529 " + RandomStringUtils.random(7, false, true);
	}

	@Override
	public String getValue(int characters) {
		return "+37529 " + RandomStringUtils.random(characters, false, true);
	}

	private static final class GeneratorHolder {
		static ContactNumberGenerator instance = new ContactNumberGenerator();
	}

	public static ContactNumberGenerator getInstance() {
		return GeneratorHolder.instance;
	}
}
