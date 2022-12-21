package org.astashonok.springjpa;

import org.astashonok.springjpa.repositories.ProductRepository;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.infra.Blackhole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class FindProductByIdBenchmarkTest extends AbstractBenchmark {

	private static ProductRepository productRepository;

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	public void findProductByIdAverageTime(Blackhole blackhole) {
		blackhole.consume(productRepository.findById("863967fd-3bdb-42ba-a6a2-18c7c182c7cd"));
	}

	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void findProductByIdThroughput(Blackhole blackhole) {
		blackhole.consume(productRepository.findById("863967fd-3bdb-42ba-a6a2-18c7c182c7cd"));
	}
}
