package org.astashonok.springjpa.repositories;

import org.astashonok.springjpa.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

	List<Product> findByBrandAndColor(String brand, String color);

	List<Product> findBySizeBetween(double min, double max);

	@Query(value = "SELECT product.id," +
			"       product.category," +
			"       product.brand," +
			"       product.color," +
			"       product.size," +
			"       product.height," +
			"       product.width," +
			"       product.weight," +
			"       product.screen," +
			"       product.\"frontCamera\"," +
			"       product.\"realCamera\"," +
			"       product.capacity," +
			"       product.\"displayTechnology\"," +
			"       product.graphic," +
			"       product.active," +
			"       product.\"execTime\"" +
			"FROM \"user\"" +
			"JOIN \"order\" ON \"user\".id = \"order\".\"userId\"" +
			"JOIN \"orderItem\" ON \"order\".id = \"orderItem\".\"orderId\"" +
			"JOIN \"product\" ON product.id = \"orderItem\".\"productId\"" +
			"WHERE name = :userName", nativeQuery = true)
	List<Product> findOrderedProductForUserName(@Param("userName") String userName);
}
