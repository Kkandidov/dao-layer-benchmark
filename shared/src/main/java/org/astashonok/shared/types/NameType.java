package org.astashonok.shared.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum NameType implements FeatureType {

	VITYA("Vity"),
	PETYA("Petya"),
	SERGE("Serge"),
	KOSTYA("Kostya"),
	LENA("Lena"),
	YULYA("Yulya"),
	SASHA("Sasha"),
	JENYA("Jenya"),
	VASYA("Vasya");

	private final String name;
}
