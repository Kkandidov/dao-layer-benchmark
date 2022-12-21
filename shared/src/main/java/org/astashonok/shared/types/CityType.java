package org.astashonok.shared.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CityType implements FeatureType {

	SEATTLE("Seattle"),
	SPOKANE("Spokane"),
	TACOMA("Tacoma"),
	VANCOUVER("Vancouver"),
	BELLEVUE("Bellevue"),
	KENT("Kent"),
	EVERETT("Everett"),
	AUBURN("Auburn"),
	PASCO("Pasco");

	private final String name;
}
