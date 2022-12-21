package org.astashonok.shared.generators.types;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.astashonok.shared.types.CategoryType;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CategoryGenerator extends BaseTypeGenerator<CategoryType> {

	@Override
	protected CategoryType[] getTypeValues() {
		return CategoryType.values();
	}

	private static final class GeneratorHolder {
		static CategoryGenerator instance = new CategoryGenerator();
	}

	public static CategoryGenerator getInstance() {
		return GeneratorHolder.instance;
	}
}
