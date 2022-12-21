package org.astashonok.springjdbc;

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
		blackhole.consume(productRepository.findById("d18fe3c2-e865-4d87-95ba-3bc920bab938"));
	}

	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void findProductByIdThroughput(Blackhole blackhole) {
		blackhole.consume(productRepository.findById("d18fe3c2-e865-4d87-95ba-3bc920bab938"));
	}
}
