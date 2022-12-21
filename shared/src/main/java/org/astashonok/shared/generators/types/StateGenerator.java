package org.astashonok.shared.generators.types;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.astashonok.shared.types.StateType;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StateGenerator extends BaseTypeGenerator<StateType> {

	@Override
	protected StateType[] getTypeValues() {
		return StateType.values();
	}

	private static final class GeneratorHolder {
		static StateGenerator instance = new StateGenerator();
	}

	public static StateGenerator getInstance() {
		return GeneratorHolder.instance;
	}
}
