package org.astashonok.shared.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonUtils {

	public static <T, R> List<R> map(@NonNull List<T> objects, Function<T, R> mapper) {
		return objects.stream()
				.filter(Objects::nonNull)
				.map(mapper)
				.filter(Objects::nonNull)
				.collect(Collectors.toList());
	}
}
