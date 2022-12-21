package org.astashonok.springjdbc;

import org.astashonok.shared.types.BrandType;
import org.astashonok.shared.types.ColorType;
import org.astashonok.springjdbc.repositories.ProductRepository;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.infra.Blackhole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class FindProductByBrandAndColorBenchmarkTest extends AbstractBenchmark {

	private static ProductRepository productRepository;

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	public void findProductByBrandAndColorAverageTime(Blackhole blackhole) {
		blackhole.consume(productRepository.findByBrandAndColor(BrandType.SAMSUNG.getName(), ColorType.BLACK.getName()));
	}

	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void findProductByBrandAndColorThroughput(Blackhole blackhole) {
		blackhole.consume(productRepository.findByBrandAndColor(BrandType.SAMSUNG.getName(), ColorType.BLACK.getName()));
	}
}
