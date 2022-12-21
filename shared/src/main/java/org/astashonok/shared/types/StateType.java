package org.astashonok.shared.types;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum StateType implements FeatureType {

	ALABAMA("Alabama"),
	ALASKA("Alaska"),
	IDAHO("Idaho"),
	CONNECTICUT("Connecticut"),
	LOUISIANA("Louisiana"),
	ARIZONA("Arizona"),
	MAINE("Maine"),
	HAWAII("Hawaii"),
	FLORIDA("Florida");

	private final String name;
}
