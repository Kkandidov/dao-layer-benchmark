package org.astashonok.springjpa;

import org.astashonok.shared.entities.IEntity;
import org.astashonok.shared.models.EntityBatch;
import org.astashonok.springjpa.entities.Order;
import org.astashonok.springjpa.entities.OrderItem;
import org.astashonok.springjpa.entities.Product;
import org.astashonok.springjpa.entities.User;
import org.astashonok.springjpa.generators.EntitiesGenerator;
import org.astashonok.springjpa.repositories.OrderItemRepository;
import org.astashonok.springjpa.repositories.OrderRepository;
import org.astashonok.springjpa.repositories.ProductRepository;
import org.astashonok.springjpa.repositories.UserRepository;
import org.openjdk.jmh.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class InsertBenchmarkTest extends AbstractBenchmark {

	private static OrderRepository orderRepository;
	private static OrderItemRepository orderItemRepository;
	private static ProductRepository productRepository;
	private static UserRepository userRepository;
	private static EntitiesGenerator entitiesGenerator;

	@Autowired
	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Autowired
	public void setOrderItemRepository(OrderItemRepository orderItemRepository) {
		this.orderItemRepository = orderItemRepository;
	}

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	public void setEntitiesGenerator(EntitiesGenerator entitiesGenerator) {
		this.entitiesGenerator = entitiesGenerator;
	}

	@Param({"10000", "50000"})
	public int batchSize;

	public EntityBatch<User, Product, Order, OrderItem> entityBatch;

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	@OutputTimeUnit(TimeUnit.NANOSECONDS)
	public void insertAverageTime(InsertBenchmarkTest state) {
		saveEntities(userRepository, state.entityBatch.getUsers());
		saveEntities(productRepository, state.entityBatch.getProducts());
		saveEntities(orderRepository, state.entityBatch.getOrders());
		saveEntities(orderItemRepository, state.entityBatch.getOrderItems());
	}

	@Benchmark
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.MINUTES)
	public void insertThroughput(InsertBenchmarkTest state) {
		saveEntities(userRepository, state.entityBatch.getUsers());
		saveEntities(productRepository, state.entityBatch.getProducts());
		saveEntities(orderRepository, state.entityBatch.getOrders());
		saveEntities(orderItemRepository, state.entityBatch.getOrderItems());
	}

	private <E extends IEntity> void saveEntities(CrudRepository<E, String> repository, List<E> entities) {
		for (E entity : entities) {
			repository.save(entity);
		}
	}

	@Setup(Level.Invocation)
	public void setUp() {
		switch (batchSize) {
			case 10000:
				entityBatch = entitiesGenerator
						.getEntityBatch(500, 1500, 4, 3);
				break;
			case 50000:
				entityBatch = entitiesGenerator
						.getEntityBatch(2500, 7500, 4, 3);
				break;
		}
	}
}
