package org.astashonok.shared.generators.types;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.astashonok.shared.types.BrandType;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BrandGenerator extends BaseTypeGenerator<BrandType> {

	@Override
	protected BrandType[] getTypeValues() {
		return BrandType.values();
	}

	private static final class GeneratorHolder {
		static BrandGenerator instance = new BrandGenerator();
	}

	public static BrandGenerator getInstance() {
		return GeneratorHolder.instance;
	}
}