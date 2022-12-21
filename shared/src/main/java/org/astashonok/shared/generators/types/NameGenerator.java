package org.astashonok.shared.generators.types;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.astashonok.shared.types.NameType;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NameGenerator extends BaseTypeGenerator<NameType> {

	@Override
	protected NameType[] getTypeValues() {
		return NameType.values();
	}

	private static final class GeneratorHolder {
		static NameGenerator instance = new NameGenerator();
	}

	public static NameGenerator getInstance() {
		return GeneratorHolder.instance;
	}
}
