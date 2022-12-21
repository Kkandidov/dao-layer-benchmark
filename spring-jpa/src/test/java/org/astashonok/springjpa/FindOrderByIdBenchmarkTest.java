package org.astashonok.springjpa;

import org.astashonok.springjpa.repositories.OrderRepository;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.infra.Blackhole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class FindOrderByIdBenchmarkTest extends AbstractBenchmark {

	private static OrderRepository orderRepository;

	@Autowired
	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	public void findOrderByIdAverageTime(Blackhole blackhole) {
		blackhole.consume(orderRepository.findById("20b8291e-d4ec-4e13-9fc2-7227ff605e2a"));
	}

	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void findOrderByIdThroughput(Blackhole blackhole) {
		blackhole.consume(orderRepository.findById("20b8291e-d4ec-4e13-9fc2-7227ff605e2a"));
	}
}
