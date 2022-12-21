package org.astashonok.shared.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CountryType implements FeatureType {

	ALBANIA("Albania"),
	BRAZIL("Brazil"),
	CUBA("Cuba"),
	KIRIBATI("Kiribati"),
	MONACO("Monaco"),
	PAKISTAN("Pakistan"),
	TONGA("Tonga"),
	ZAMBIA("Zambia"),
	VENEZUELA("Venezuela");

	private final String name;
}
