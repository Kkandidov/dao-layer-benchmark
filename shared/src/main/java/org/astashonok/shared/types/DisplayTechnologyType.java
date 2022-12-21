package org.astashonok.shared.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum DisplayTechnologyType implements FeatureType {

	OLED("oled"),
	AMOLED("amoled"),
	SUPER_AMOLED("super amoled");

	private final String name;
}
