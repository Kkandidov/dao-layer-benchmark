package org.astashonok.shared.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ColorType implements FeatureType {
	BLACK("black"),
	SILVER("silver"),
	GRAY("gray"),
	WHITE("white"),
	MAROON("maroon"),
	RED("red"),
	PURPLE("purple"),
	FUCHSIA("fuchsia"),
	GREEN("gren"),
	OLIVE("olive"),
	YELLOW("yellow");

	private final String name;
}
