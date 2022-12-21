package org.astashonok.shared.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum GraphicType implements FeatureType {

	RADEON("radeon"),
	GEFORCE("geforce");

	private final String name;
}
