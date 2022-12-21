package org.astashonok.shared.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum BrandType implements FeatureType {
	APPLE("apple"),
	GOOGLE("google"),
	SAMSUNG("samsung"),
	XIAOMI("xiaomi"),
	VIVO("vivo"),
	OPPO("oppo"),
	REALME("realmi");

	private final String name;
}
