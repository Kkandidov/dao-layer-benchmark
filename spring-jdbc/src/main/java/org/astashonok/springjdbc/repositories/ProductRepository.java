package org.astashonok.springjdbc.repositories;

import org.astashonok.springjdbc.entities.Product;

import java.util.List;

public interface ProductRepository extends EntityRepository<Product> {

	Product findById(String id);

	List<Product> findByBrandAndColor(String brand, String color);

	List<Product> findBySizeBetween(double min, double max);

	List<Product> findOrderedProductForUserName(String userName);
}
