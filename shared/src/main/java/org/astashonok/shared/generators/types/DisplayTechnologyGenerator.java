package org.astashonok.shared.generators.types;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.astashonok.shared.types.DisplayTechnologyType;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DisplayTechnologyGenerator extends BaseTypeGenerator<DisplayTechnologyType> {

	@Override
	protected DisplayTechnologyType[] getTypeValues() {
		return DisplayTechnologyType.values();
	}

	private static final class GeneratorHolder {
		static DisplayTechnologyGenerator instance = new DisplayTechnologyGenerator();
	}

	public static DisplayTechnologyGenerator getInstance() {
		return GeneratorHolder.instance;
	}
}
