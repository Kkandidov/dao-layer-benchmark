package org.astashonok.shared.generators.types;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.astashonok.shared.types.ColorType;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ColorGenerator extends BaseTypeGenerator<ColorType> {

	@Override
	protected ColorType[] getTypeValues() {
		return ColorType.values();
	}

	private static final class GeneratorHolder {
		static ColorGenerator instance = new ColorGenerator();
	}

	public static ColorGenerator getInstance() {
		return GeneratorHolder.instance;
	}
}
