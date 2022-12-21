package org.astashonok.shared.generators.types;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.astashonok.shared.types.CityType;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CityGenerator extends BaseTypeGenerator<CityType> {

	@Override
	protected CityType[] getTypeValues() {
		return CityType.values();
	}

	private static final class GeneratorHolder {
		static CityGenerator instance = new CityGenerator();
	}

	public static CityGenerator getInstance() {
		return GeneratorHolder.instance;
	}
}
