package org.astashonok.shared.generators.types;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.astashonok.shared.types.CountryType;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CountryGenerator extends BaseTypeGenerator<CountryType> {

	@Override
	protected CountryType[] getTypeValues() {
		return CountryType.values();
	}

	private static final class GeneratorHolder {
		static CountryGenerator instance = new CountryGenerator();
	}

	public static CountryGenerator getInstance() {
		return GeneratorHolder.instance;
	}
}
