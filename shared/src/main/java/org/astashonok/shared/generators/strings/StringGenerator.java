package org.astashonok.shared.generators.strings;

import org.astashonok.shared.generators.Generator;

public interface StringGenerator extends Generator<String> {

	String getValue(int characters);
}
