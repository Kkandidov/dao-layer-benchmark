package org.astashonok.springjdbc.repositories.impl;

import org.astashonok.springjdbc.entities.Product;
import org.astashonok.springjdbc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	private static final String INSERT_PRODUCT_QUERY = "INSERT INTO product(id, category, brand,"
			+ " color, size, height, width, weight, screen, \"frontCamera\", \"realCamera\", capacity, "
			+ "\"displayTechnology\", graphic, active) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	private static final String GET_PRODUCT_BY_ID_QUERY = "SELECT * FROM product WHERE id=?";
	private static final String GET_PRODUCTS_BY_BRAND_AND_COLOR_QUERY = "SELECT * FROM product WHERE brand=? AND color=?";
	private static final String GET_PRODUCTS_BY_SIZE_BETWEEN = "SELECT * FROM product WHERE size>=? AND size < ?";
	private static final String GET_ORDERED_PRODUCTS_FOR_USER = "SELECT product.id," +
			" product.category," +
			" product.brand," +
			" product.color," +
			" product.size," +
			" product.height," +
			" product.width," +
			" product.weight," +
			" product.screen," +
			" product.\"frontCamera\"," +
			" product.\"realCamera\"," +
			" product.capacity," +
			" product.\"displayTechnology\"," +
			" product.graphic," +
			" product.active," +
			" product.\"execTime\"" +
			"FROM \"user\"" +
			"JOIN \"order\" ON \"user\".id = \"order\".\"userId\"" +
			"JOIN \"orderItem\" ON \"order\".id = \"orderItem\".\"orderId\"" +
			"JOIN \"product\" ON product.id = \"orderItem\".\"productId\"" +
			"WHERE name = ?;";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private BeanPropertyRowMapper<Product> productMapper;

	@Override
	public int save(Product entity) {
		return jdbcTemplate.update(INSERT_PRODUCT_QUERY, entity.getId(), entity.getCategory(), entity.getBrand(),
				entity.getColor(), entity.getSize(), entity.getHeight(), entity.getWidth(), entity.getWeight(),
				entity.getScreen(), entity.getFrontCamera(), entity.getRealCamera(), entity.getCapacity(),
				entity.getDisplayTechnology(), entity.getGraphic(), entity.getActive());
	}

	@Override
	public Product findById(String id) {
		return jdbcTemplate.queryForObject(
				GET_PRODUCT_BY_ID_QUERY,
				productMapper,
				id);
	}

	@Override
	public List<Product> findByBrandAndColor(String brand, String color) {
		return jdbcTemplate.query(
				GET_PRODUCTS_BY_BRAND_AND_COLOR_QUERY,
				productMapper,
				brand, color);
	}

	@Override
	public List<Product> findBySizeBetween(double min, double max) {
		return jdbcTemplate.query(
				GET_PRODUCTS_BY_SIZE_BETWEEN,
				productMapper,
				min, max);
	}

	@Override
	public List<Product> findOrderedProductForUserName(String userName) {
		return jdbcTemplate.query(
				GET_ORDERED_PRODUCTS_FOR_USER,
				productMapper,
				userName);
	}
}
