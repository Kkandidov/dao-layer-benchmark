package org.astashonok.shared.generators.types;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.astashonok.shared.types.GraphicType;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GraphicGenerator extends BaseTypeGenerator<GraphicType> {

	@Override
	protected GraphicType[] getTypeValues() {
		return GraphicType.values();
	}

	private static final class GeneratorHolder {
		static GraphicGenerator instance = new GraphicGenerator();
	}

	public static GraphicGenerator getInstance() {
		return GeneratorHolder.instance;
	}
}
