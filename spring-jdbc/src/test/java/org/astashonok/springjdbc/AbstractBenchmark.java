package org.astashonok.springjdbc;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

@State(Scope.Benchmark)
public abstract class AbstractBenchmark {

	private static final Integer MEASUREMENT_ITERATIONS = 3;
	private static final Integer WARMUP_ITERATIONS = 3;

	private static final String ROOT_DIRECTORY = "src/test/resources/benchmark/";

	@Test
	public void executeJmhRunner() throws RunnerException {
		Options opt = new OptionsBuilder()
				.include(getClass().getName())
				.warmupIterations(WARMUP_ITERATIONS)
				.measurementIterations(MEASUREMENT_ITERATIONS)
				.forks(0)
				.threads(1)
				.shouldDoGC(true)
				.shouldFailOnError(true)
				.resultFormat(ResultFormatType.JSON)
				.result(getResultFileName())
				.shouldFailOnError(true)
				.jvmArgs("-server")
				.build();

		new Runner(opt).run();
	}

	@SneakyThrows
	private String getResultFileName() {
		Path filePath = Path.of(ROOT_DIRECTORY);
		if (!Files.exists(filePath)) {
			Files.createDirectory(filePath);
		}

		String className = getClass().getSimpleName().toLowerCase();
		filePath =  Path.of(ROOT_DIRECTORY + "/" + className);

		if (!Files.exists(filePath)) {
			Files.createDirectory(filePath);
		}

		LocalDateTime now = LocalDateTime.now();

		return filePath
				+ "\\"
				+ className
				+ "-"
				+ now.getYear()
				+ "-"
				+ now.getMonth().getValue()
				+ "-"
				+ now.getDayOfMonth()
				+ "-"
				+ now.getHour()
				+ "-"
				+ now.getMinute()
				+ "-" + now.getSecond();
	}
}
