package org.astashonok.shared.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CategoryType implements FeatureType {

	LAPTOP("laptop"),
	TELEVISION("television"),
	SMART_PHONE("smartphone"),
	TABLET("tablet");

	private final String name;
}
